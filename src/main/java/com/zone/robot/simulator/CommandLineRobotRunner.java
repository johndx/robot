package com.zone.robot.simulator;

import com.zone.robot.simulator.services.SimulatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * Created by jonathanDyke on 30/06/2019.
 */
@Component
public class CommandLineRobotRunner  implements CommandLineRunner {

    @Autowired
    private SimulatorService simulatorService;

    private static final Logger logger = LoggerFactory.getLogger(CommandLineRobotRunner.class);

    /**
     * Bootstrap the Application and dependency inject the Service.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String...args) throws Exception {


        logger.info("Robot Application started Processing" );

        simulatorService.simulate();

    }
}