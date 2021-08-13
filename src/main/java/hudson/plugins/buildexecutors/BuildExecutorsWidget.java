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
@Extension(ordinal = 99)
public class BuildExecutorsWidget extends Widget {

    public boolean hideOfflineNodes = false;

    public boolean hideTemporarilyOfflineNodes = false;

    Logger LOGGER = Logger.getLogger(BuildExecutorsWidget.class);

    public String getWidgetName() {
        return "Build Executors";
    }

    public String getWidgetId() {
        return "build-executors";
    }

    @JavaScriptMethod
    public void showOrHideOffline() {
        LOGGER.debug(!hideOfflineNodes);
        hideOfflineNodes = !hideOfflineNodes;
    }

    @JavaScriptMethod
    public void showOrHideTemporarilyOffline() {
        LOGGER.debug(!hideTemporarilyOfflineNodes);
        hideTemporarilyOfflineNodes = !hideTemporarilyOfflineNodes;
    }

    @JavaScriptMethod
    public void debug(String message) {
        LOGGER.debug(message);
    }

    public String getOfflineNodesSwitch() {
        if (hideOfflineNodes) {
            return "show offline nodes";
        } else {
            return "hide offline nodes";
        }
    }

    public String getTemporarilyOfflineNodesSwitch() {
        if (hideTemporarilyOfflineNodes) {
            return "show temporarily offline nodes";
        } else {
            return "hide temporarily offline nodes";
        }
    }

    public List<Computer> getActiveComputers() {
        List<Computer> computers = new ArrayList<>();
        for (Computer computer : Jenkins.get().getComputers()) {
            if (computer.isOnline()
                    || !hideOfflineNodes
                    || (computer.isTemporarilyOffline() && !hideTemporarilyOfflineNodes)) {
                computers.add(computer);
            }
        }
        return computers;
    }
}
