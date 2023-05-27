<%@include file="/common/taglib.jsp"%>

<nav class="navbar navbar-expand-lg bg-primary py-3">
	<div class="container">
		<a class="navbar-brand" href="home"><i
			class="fa-solid fa-graduation-cap"></i> E Notes</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="note?type=add"><i
						class="fa-solid fa-circle-plus"></i> Add Note</a></li>
				<li class="nav-item"><a class="nav-link" href="note?type=list"><i
						class="fa-solid fa-note-sticky"></i> Show Note</a></li>
			</ul>
			<c:choose>
				<c:when test="${not empty userModel}">
					<button type="button" class="btn btn-primary btn-profile me-2"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						<i class="fa-solid fa-circle-user"></i> ${userModel.fullName }
					</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-5" id="exampleModalLabel">Profile</h1>
								</div>
								<div class="modal-body">
									<p><span class="fw-bolder">User id:</span> ${userModel.id }</p>
									<p><span class="fw-bolder">Full name:</span> ${userModel.fullName }</p>
									<p><span class="fw-bolder">Email:</span> ${userModel.email }</p>
									<p><span class="fw-bolder">Created date:</span> <fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${userModel.createdDate}" pattern="dd/MM/yyyy HH:mm:ss" /></p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>

					<a href="auth?action=logout" class="btn btn-outline-light"><i
						class="fa-solid fa-right-from-bracket"></i> Logout</a>
				</c:when>
				<c:otherwise>
					<a href="auth?action=login" class="btn btn-outline-light"><i
						class="fa-solid fa-right-to-bracket"></i> Login</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>