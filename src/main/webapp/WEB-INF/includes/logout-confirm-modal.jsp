<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="LogoutModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="LogoutModalLabel">Log out confirmation</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                </button>
            </div>
            <div class="modal-body text-center">
                <h4>Are you sure to log out?</h4>
            </div>
            <div class="modal-footer">
                <a href="${pageContext.request.contextPath}/logout"><button type="button" class="btn btn-primary">Yes</button></a>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>