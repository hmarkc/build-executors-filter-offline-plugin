//function refresh(id, computers) {
//    var intervalID = null;
//    var hist = $(id);
//    if (hist == null) {
//        console.log("There's no element that has ID of " + id);
//        if (intervalID !== null) {
//            window.clearInterval(intervalID);
//            return;
//        }
//
//        var p = hist.up();
//        var div = document.createElement('div');
//        div.innerHTML = "<j:forEach var=\"c\" items=\"${computers}\">" +
//                        "<j:set var=\"cDisplayExecutors\" value=\"${c.displayExecutors}\"/>" +
//                        "<tr><j:if test=\"${!cDisplayExecutors.isEmpty()}\"><th class=\"pane\" colspan=\"4\"><local:computerCaption title=\"${c.displayName}\"/>" +
//                        "</th></j:if></tr>" +
//                        "<j:forEach var=\"de\" items=\"${cDisplayExecutors}\" varStatus=\"eloop\">" +
//                        "<j:set var=\"e\" value=\"${de.executor}\"/>" +
//                        "<local:executor name=\"${de.displayName}\" url=\"${de.url}\"/>" +
//                        "</j:forEach>" +
//                        "</j:forEach>"
//
//        var node = $(div).firstDescendant();
//        p.replaceChild(node, hist);
//
//        Behaviour.applySubtree(node);
//        layoutUpdateCallback.call();
//    }
//    intervalID = window.setInterval(f, 1000);
//}

function update(computers) {
//    location.reload();
    var panel = document.getElementById("panel");
    while (panel.firstChild) {
        panel.removeChild(panel.lastChild);
    }
    for (var i = 0; i < computers.length; i++) {
        widget.debug(2 * i);
        var c = computers[i];
        var cDisplayExecutors = c.displayExecutors;
        var tr = document.createElement("tr");
//        if (cDisplayExecutors.length != 0) {
//            var th = document.createElement("th");
//            th.className = "pane";
//            var computerCaption = document.createElement("computerCaption");
//            computerCaption.title = c.displayName;
//            th.appendChild(computerCaption);
//            th.colspan = "4";
//            tr.appendChild(th);
//            var th = document.createElement("div");
//            th.innerHTML =
//        }
        panel.appendChild(tr);
        widget.debug(c);
    }
    widget.debug(panel.innerHTML + computers.length);
}