package io.flowsquad.camunda.test.delegates.real.projectexecution.migrationperaccess;

import io.flowsquad.camunda.test.util.Approval;
import io.flowsquad.camunda.test.util.JsonMappingUtils;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@Component("DetermineInternalExternalOrderTasksDelegate")
public class DetermineInternalExternalOrderTasksDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info(this.getClass().getSimpleName());
        LinkedHashMap linkedHashMap = (LinkedHashMap) execution.getVariable("access");

        Approval approval = new Approval();
        approval.setId((Integer) linkedHashMap.get("id"));
        approval.setName("name");
        List<Approval> approvalList = new ArrayList<>(1);
        approvalList.add(approval);

        String json = JsonMappingUtils.convertToString(approvalList, false);

        execution.setVariable("approvals",  JsonMappingUtils.convertToObject(json, Collection.class));
        execution.setVariable("taskAction", "REJECTED");
        execution.setVariable("hasOPENAccesses", true);
        execution.setVariable("isProjectCancelled", false);
    }
}
