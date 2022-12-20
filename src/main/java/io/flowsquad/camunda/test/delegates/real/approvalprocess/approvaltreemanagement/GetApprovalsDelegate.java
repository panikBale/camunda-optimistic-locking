package io.flowsquad.camunda.test.delegates.real.approvalprocess.approvaltreemanagement;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("GetApprovalsDelegate")
public class GetApprovalsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info(this.getClass().getSimpleName());
    }
}
