package io.flowsquad.camunda.test.delegates.real.projectexecution.ecupliftonboardingprocess;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("CreateMigrationProjectDelegate")
public class CreateMigrationProjectDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info(this.getClass().getSimpleName());
    }
}