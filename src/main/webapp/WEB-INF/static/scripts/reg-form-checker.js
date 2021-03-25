const doRegButton = document.getElementById("button-submit");

const password_1 = document.getElementById("password-1");
const password_2 = document.getElementById("password-2");

const span = document.getElementById("password-checker-span");

password_1.addEventListener("keyup", checkPasswords);
password_2.addEventListener("keyup", checkPasswords);

doRegButton.addEventListener("click", (event) => {
    if (password_1.value != password_2.value)
        event.preventDefault();
})

function checkPasswords() {
    if (password_1.value != password_2.value) {
        span.innerText = "Пароли не совпадают";
        password_1.style.borderColor = password_2.style.borderColor = "#6E00B3";
        password_1.style.borderWidth = password_2.style.borderWidth = "4px";
    }
    else {
        span.innerText = "";
        password_1.style.borderColor = password_2.style.borderColor = "#B3B3B3";
        password_1.style.borderWidth = password_2.style.borderWidth = "2px";
    }
}