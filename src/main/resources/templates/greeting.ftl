<!-- Шаблон страницы приветсвия -->
<#import "layouts/default.ftl" as layout> <!-- Подключение базового шаблона -->

    <!-- Контент страницы -->
<@layout.page currentPage="greeting">
    <div class="jumbotron mt-4">
        <h1>Sweater - клон twitter на Java</h1>
        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
            aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
            dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
            deserunt mollit anim id est laborum.</p>
    </div>

    <div class="card-deck mt-4">
        <div class="card">
            <a href="https://spring.io" target="_blank">
                <img src="../static/img/springLogo.svg" class="card-img-top" alt="Spring Boot">
            </a>
            <div class="card-body">
                <h5 class="card-title">Spring Boot</h5>
                <p class="card-text">Универсальный фреймворк с открытым исходным кодом для Java-платформы. Позволяет создавать веб-приложения.</p>
            </div>
            <div class="card-footer text-center">
                <a href="https://spring.io" target="_blank" class="btn btn-primary">Spring</a>
            </div>
        </div>

        <div class="card">
            <a href="https://maven.apache.org" target="_blank">
                <img src="../static/img/mavenLogo.svg" class="card-img-top" alt="Maven">
            </a>
            <div class="card-body">
                <h5 class="card-title">Maven</h5>
                <p class="card-text">Фреймворк для автоматизации сборки проектов на основе описания их структуры в файлах на языке POM.</p>
            </div>
            <div class="card-footer text-center">
                <a href="https://maven.apache.org" target="_blank" class="btn btn-primary">Maven</a>
            </div>
        </div>

        <div class="card">
            <a href="https://www.mysql.com" target="_blank">
                <img src="../static/img/mysqlLogo.svg" class="card-img-top" alt="MySQL">
            </a>
            <div class="card-body">
                <h5 class="card-title">MySQL</h5>
                <p class="card-text">Свободная реляционная система управления базами данных.</p>
            </div>
            <div class="card-footer text-center">
                <a href="https://www.mysql.com" target="_blank" class="btn btn-primary">MySQL</a>
            </div>
        </div>

        <div class="card">
            <a href="https://getbootstrap.com" target="_blank">
                <img src="../static/img/bootstrapLogo.svg" class="card-img-top" alt="Bootstrap">
            </a>
            <div class="card-body">
                <h5 class="card-title">Bootstrap</h5>
                <p class="card-text">Инструментарий с открытым исходным кодом для разработки веб-сайтов с помощью HTML, CSS и JS.</p>
            </div>
            <div class="card-footer text-center">
                <a href="https://getbootstrap.com" target="_blank" class="btn btn-primary">Bootstrap</a>
            </div>
        </div>
    </div>
</@layout.page>