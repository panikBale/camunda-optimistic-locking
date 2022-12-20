package io.flowsquad.camunda.test.delegates.real.projectexecution;

import io.flowsquad.camunda.test.util.Accesses;
import io.flowsquad.camunda.test.util.JsonMappingUtils;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component("CreateVariableAccessDelegate")
public class CreateVariableAccessDelegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info(this.getClass().getSimpleName());

        List<Accesses> list = createList();
        String json = JsonMappingUtils.convertToString(list, false);
        execution.setVariable("accesses", JsonMappingUtils.convertToObject(json, Collection.class));
    }

    private List<Accesses> createList () {
        List<Accesses> list = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            Accesses accesses = new Accesses();
            accesses.setId(i);
            accesses.setStatus("OPEN");
            list.add(accesses);
        }
        return list;
    }
}
