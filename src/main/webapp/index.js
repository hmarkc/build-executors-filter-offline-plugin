function toggleFilterOffline(isTemporary) {
    if (isTemporary === false) {
        widget.showOrHideOffline();
    } else {
        widget.showOrHideTemporarilyOffline();
    }
    setTimeout(function() { window.location.reload() }, 1000);
}