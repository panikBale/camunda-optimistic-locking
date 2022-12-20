package io.flowsquad.camunda.test.delegates.real.approvalprocess.obtainapprovalprocess;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.model.bpmn.instance.TimeDate;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component("WaitingTimer")
public class WaitingTimer  implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info(this.getClass().getSimpleName());
        Map<String, Object> accessRoot  =   (Map<String, Object>) execution.getVariable("access");
        Integer             id          =   (Integer) accessRoot.get("id");

        if (id == 1) {
            TimeUnit.MILLISECONDS.sleep(300);
        }
        log.info("--------- TIMER --------- : " + LocalTime.now());
    }
}
