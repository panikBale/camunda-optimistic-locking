package io.flowsquad.camunda.test.delegates.prototype;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component("CreateCollectionDelegate")
public class CreateCollectionDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CreateCollectionDelegate");
        List<String> collection = new ArrayList<>();
        collection.add("1");
        collection.add("2");
        execution.setVariable("collection", collection);
    }
}
