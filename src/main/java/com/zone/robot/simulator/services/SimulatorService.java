package com.zone.robot.simulator.services;

import com.zone.robot.simulator.domain.Robot;
import com.zone.robot.simulator.util.GridLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by jonathanDyke on 30/06/2019.
 */
@Service
public class SimulatorService {

    private static final String fileName = "cmdFile.txt";

    // Regex to split on both space and ,
    private static final String DELIM_REG_EX  = "\\s|,";


    private static final Logger logger = LoggerFactory.getLogger(SimulatorService.class);

    private Optional<Robot> placeHolder = Optional.empty();

    /**
     * Simulate the processing of Commands to  the Robot.
     * This Service decouples the exraction, validation and marshalling of the
     * Commands from the text file, from the functionality of the Robot.
     *
     */
    public void simulate() {



        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {

            stream.forEach(c -> {   logger.info("Processing raw command :" + c );
                                    String[] robotCmdArgs  = c.split(DELIM_REG_EX);
                                    processSingleCmd(robotCmdArgs);

                    }
            );

        } catch (IOException e) {
            e.printStackTrace();
            logger.info("IOException processing commands :" );
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            logger.info("URISyntaxException processing commands :" );
        }
    }



    /**
     * Command Parser and delegater.
     * @param cmdArgs
     */
    private void processSingleCmd(final String[] cmdArgs) {

        switch (cmdArgs[0].toUpperCase()) {

            case "PLACE":
                logger.info("PLACE - Request received");
                GridLocation location =  new GridLocation(  Integer.parseInt(cmdArgs[1]),
                                                            Integer.parseInt(cmdArgs[2]),
                                                            GridLocation.FACING.valueOf(cmdArgs[3]));
                placeHolder = Optional.of( new Robot(location) );
                break;

            case "MOVE":
                logger.info("MOVE - Request received");
                if (placeHolder.isPresent()) {
                    placeHolder.get().move();
                }
                break;

            case "LEFT":
                logger.info("LEFT - Request received");
                if (placeHolder.isPresent()) {
                    placeHolder.get().left();
                }
                break;

            case "RIGHT":
                logger.info("RIGHT - Request received");
                if (placeHolder.isPresent()) {
                    placeHolder.get().right();
                }
                break;

            case "REPORT":
                logger.info("REPORT - Request received");
                if (placeHolder.isPresent()) {
                    placeHolder.get().report();
                }
                break;

            default:
                logger.info("NO Intelligible  - Request received");
                // Unable to match any command - ignore
                break;
        }
    }

}
