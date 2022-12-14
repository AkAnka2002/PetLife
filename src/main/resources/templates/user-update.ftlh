<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1>PetLife</h1><hr>
    <h4>Редактирование профиля</h4>

    <form method="post" enctype="multipart/form-data">
        Имя: <input type="text" name="name" placeholder="${user.name}"/><br><br>
        Адрес электронной почты: <input type="text" name="email" placeholder="${user.email}"/><br><br>
        Номер телефона: <input type="text" name="phoneNumber" placeholder="${user.phoneNumber}"><br><br>
        Гендерная принадлежность:
        <select class="form-select" aria-label="Default select example" name="gender">
            <option selected id="gender"> ${user.gender} </option>
            <option value="Мужчина">Мужчина</option>
            <option value="Женщина">Женщина</option>
            <option value="Другое">Другое</option>
            <option value="Не указывать">Не указывать</option>
        </select>
        Аватар: <img src="/images/${image.id?c}" height="60ps"/> <br><br>
        <input type="file" name="file"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Изменить профиль"/>
    </form>
</@t.template>