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
				<li class="nav-item"><a class="nav-link" href="home"><i
						class="fa-solid fa-house"></i> Home</a></li>
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

					<a href="auth?action=logout" class="btn btn-outline-light"><i
						class="fa-solid fa-right-from-bracket"></i> Logout</a>
				</c:when>
				<c:otherwise>
					<a href="auth?action=login" class="btn btn-outline-light"><i class="fa-solid fa-right-to-bracket"></i> Login</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>