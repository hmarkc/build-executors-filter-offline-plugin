package hudson.plugins.buildexecutors;

import hudson.init.Initializer;
import hudson.widgets.Widget;
import jenkins.model.Jenkins;

import java.util.List;
import java.util.logging.Logger;

import static hudson.init.InitMilestone.PLUGINS_PREPARED;


/**
 * Used for initialization
 *
 * @author Jaroslav Otradovec
 */
public class BuildExecutorsInit {
    private final static Logger logger = Logger.getLogger(BuildExecutorsInit.class.getName());

    @SuppressWarnings("unused")
    @Initializer(after = PLUGINS_PREPARED)
    public void postInitialize() {
        List<Widget> widgets = Jenkins.get().getWidgets();
        if (widgets.isEmpty()) {
            logger.warning("Empty widget list!");
        } else {
            for (Widget widget : widgets) {
                if (widget.getClass() == jenkins.widgets.ExecutorsWidget.class) {
                    logger.info("Removing " + widget.getClass().toString());
                    Jenkins.get().getWidgets().remove(widget);
                    return;
                }
            }
        }
        logger.warning("BuildExecutors Plugin unable to remove default widget");
    }
}
