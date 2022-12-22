<#import "blocks/template.ftlh" as t>
<@t.template user>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
    <div class="calendar-wrapper" style="width: 70%">
        <button id="btnPrev" type="button">Предыдущий</button>
        <button id="btnNext" type="button">Следующий</button>
        <div id="divCal"></div>
    </div>
    <button id="notesForm" type="submit" class="btn btn-light me-2 btn-my nav_text">Показать события на эту дату</button>
   <hr>
    <h3>Добавить заметку</h3>
    <form id="noteForm" method="post" enctype="multipart/form-data">
        <p id="noteHeader"></p>
        Текст:<textarea id="textLabel" type="text" class="my-input" name="text" required></textarea><br><br>
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" class="btn btn-light me-2 btn-my nav_text" value="Добавить заметку" required/>
    </form>
    <script type="text/javascript">
        const userId = "${user.id}";
    </script>
    <script type="text/javascript" src="/webpack.config.js"></script>
</@t.template>