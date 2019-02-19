<!-- Панель навигации -->
<#macro navbar>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <a class="navbar-brand" href="index.html">Sweater</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Развернуть">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/home">Messages</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user">[A] Users</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/message">[A] Messages</a>
            </li>
        </ul>
    </div>
</nav>
</#macro>