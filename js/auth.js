async function register() {
    const email = $('input[type=email][name=email]:checked').val();
    const password = $('input[type=radio][name=password]:checked').val()
    alert(email + " " + password)
}
function displaySignUp() {
    $("#sign-up").removeClass("visually-hidden")
    $("#sign-in").addClass("visually-hidden")
    showPassword();
}
function displaySignIn() {
    $("#sign-in").removeClass("visually-hidden");
    $("#sign-up").addClass("visually-hidden");
    showPassword()
}
function showPassword() {
    var inputsPassword = document.getElementsByClassName("password");
    for (let i = 0; i < inputsPassword.length; i++) {
        if (inputsPassword[i].type === "password") {
            inputsPassword[i].type = "text";
        } else {
            inputsPassword[i].type = "password";
        }
    }
}
async function register() {
    const email = $("#emailRegister").val();
    const password = $("#passwordRegister").val()

    try {
        const response = await axios({
            method: "post",
            url: "http://localhost:8080/customers/signup",
            data: {
                email,
                password
            }
        })
        alert('Đăng kí thành công');
        window.location = "/khaibao.html";
        return response;
    } catch (error) {
        console.log(error);
        return error;
    }
}
async function signIn() {
    const email = $("#emailLogin").val();
    const password = $("#passwordLogin").val()
    console.log(email)
    console.log(password)
    try {
        const response = await axios({
            method: "post",
            url: "http://localhost:8080/customers/signin",
            data: {
                email,
                password
            }
        })
        window.location = "/khaibao.html";
        console.log(response)
        return response;
    } catch (error) {
        console.log(error);
        return error;
    }
}