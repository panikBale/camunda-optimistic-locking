package io.flowsquad.camunda.test.delegates.prototype;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component ("ThrowErrorDelegate")
public class ThrowErrorDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        throw new BpmnError("MyErrorCode", "testVariableMessage");
    }
}
