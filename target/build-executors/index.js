function load(isTemporary) {
    if (isTemporary == false) {
        widget.showOrHideOffline();
    } else {
        widget.showOrHideTemporarilyOffline();
    }
    location.reload();
}