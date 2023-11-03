const tabsBox = document.querySelector(".tabs-box");
allTabs = document.querySelectorAll(".tab")
arrowIcons = document.querySelectorAll(".destinationFil__left-icon i");

let isDragging = false;

const handleIcon= () => {
    let scrollVal = Math.round(tabsBox.scrollLeft);
    let maxScrollableWidth = tabsBox.scrollWidth - tabsBox.clientWidth;
    arrowIcons[0].parentElement.style.display = scrollVal > 0 ? "flex" : "none";
    arrowIcons[1].parentElement.style.display = maxScrollableWidth > scrollVal ? "flex" : "none";
};


arrowIcons.forEach(icon => {
    icon.addEventListener("click", () => {
        tabsBox.scrollLeft += icon.id === "left" ? -350: 350;
        setTimeout(() => handleIcon(),50);
    })
});

allTabs.forEach(tab => {
    tab.addEventListener("click", () => {
       tabsBox.querySelector(".active").classList.remove("active");
        tab.classList.add("active")
    })
});


// bộ lọc
const allFilters = document.querySelectorAll('.main__filter-a');
const searchImg = document.querySelector('.searchAddress');
const btnSearch = document.querySelector('.filter-button-handle');
const handleClickImg = document.querySelectorAll('.searchAddress__body-item-img');

allFilters.forEach(filter => {
    filter.addEventListener('click', () => {
        const activeFilter = document.querySelector('.active-black');
        activeFilter.classList.remove('active-black');
        filter.classList.add('active-black');
    });
});

btnSearch.addEventListener('click', (e) => {
    searchImg.style.display = 'inline-block';
    e.preventDefault();
});

handleClickImg.forEach(img => {
    img.addEventListener('click', () => {
        searchImg.style.display = 'none';
    });
});

document.addEventListener('click', (e) => {
    if (!searchImg.contains(e.target) && e.target !== btnSearch) {
        searchImg.style.display = 'none';
        
    }
});



// đăng kí đăng nhập
const formsModal = document.querySelector('.froms__modal'),
 pwShowHide = document.querySelectorAll('.eye-icon'),
 linksModal = document.querySelectorAll('.link-modal');

pwShowHide.forEach(eyeIcon => {
    eyeIcon.addEventListener('click', () => {
        let pwFields = eyeIcon.parentElement.parentElement.querySelectorAll('.password');

        pwFields.forEach(password => {
            if(password.type == "password") {
                password.type = 'Text';
                eyeIcon.classList.replace("fa-eye-slash", "fa-eye")
                return;
            }
            password.type = 'password';
            eyeIcon.classList.replace("fa-eye", "fa-eye-slash")
        })
    })
})

var signupLink = document.querySelector(".signup-link") 
var loginLink = document.querySelector(".sigin-link") 
var signup = document.querySelector(".signup")
var login = document.querySelector(".login")
var modal = document.querySelector('.modal');
var loginBtn =  document.querySelector('.js-login');

signupLink.addEventListener("click",() => {
    login.style.display = "none";
    signup.style.display = "inline-block";
})


loginLink.addEventListener("click",() => {
    login.style.display = "inline-block";
    signup.style.display = "none";
})


loginBtn.addEventListener("click", () => {
    modal.classList.add('open');
})


var closeModal = document.querySelector('.xmark-icon');
closeModal.addEventListener("click", () => {
    modal.classList.remove('open');
})

var closeModal2 = document.querySelector('.xmark-icon2');
closeModal2.addEventListener("click", () => {
    modal.classList.remove('open');
})



window.addEventListener("scroll", function() {
    var navbar = this.document.querySelector('.nav__menu');
    navbar.classList.toggle("hieuung", window.scrollY > 10)
})


window.onload = function() {
    let x = document.querySelector('.modal_onload') 
    let close = document.querySelector('.test') 
    x.style.display = 'flex';
    close.addEventListener('click', function() {
        x.style.display = 'none';
    })
}






