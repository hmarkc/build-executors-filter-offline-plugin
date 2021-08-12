package hudson.plugins.buildexecutors;

import hudson.Extension;

import hudson.model.Computer;
import hudson.model.Node;
import hudson.widgets.Widget;
import jenkins.model.Jenkins;
import org.apache.log4j.Logger;
import org.kohsuke.stapler.bind.JavaScriptMethod;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Extension(ordinal=99)
public class BuildExecutorsWidget extends Widget {

    private boolean hideOfflineNodes = false;

    Logger LOGGER = Logger.getLogger(BuildExecutorsWidget.class);

    public String getWidgetName() {
        return "Build Executors";
    }

    public String getWidgetId() {
        return "build-executors";
    }

    @JavaScriptMethod
    public void showOrHide() {
        LOGGER.debug("hide value is " + !hideOfflineNodes);
        hideOfflineNodes = !hideOfflineNodes;
    }

    public String getSwitchName() {
        if (hideOfflineNodes) {
            return "show offline nodes";
        } else {
            return "hide offline nodes";
        }
    }

    public List<Computer> getActiveComputers() {
        List<Computer> computers = new ArrayList<>();
        for (Computer computer : Jenkins.get().getComputers()) {
            if (computer.isOnline() || !hideOfflineNodes) {
                computers.add(computer);
            }
        }
        return computers;
    }
}
