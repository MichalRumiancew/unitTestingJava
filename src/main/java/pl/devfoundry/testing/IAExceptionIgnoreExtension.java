package pl.devfoundry.testing;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.util.logging.Logger;

public class IAExceptionIgnoreExtension implements TestExecutionExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(IAExceptionIgnoreExtension.class.getName());
    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {

        if(throwable instanceof IllegalArgumentException){
            LOGGER.info("Just ingored illegalArgumentException!");
        }else {
            throw throwable;
        }
    }
}
