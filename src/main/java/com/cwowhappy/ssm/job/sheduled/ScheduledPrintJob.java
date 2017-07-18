package com.cwowhappy.ssm.job.sheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by cwowhappy on 2017/7/4.
 */
@Component("scheduledPrintJob")
public class ScheduledPrintJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledPrintJob.class);

    @Scheduled(cron = "0/15 * * * * ?")
    public void print() {
        LOGGER.info("定时任务:[{}][{}]", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                Thread.currentThread().getName());
    }
}
