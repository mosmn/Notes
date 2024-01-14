# General techniques that are used by JavaScript programmers everyday.

# Drop-down Menus

## Allow the menu to show up either on click or on hover.

### On click

```html
<div class="dropdown">
  <button class="dropbtn">Dropdown</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>
```

```css
/* Dropdown Button */
.dropbtn {
  background-color: #3498db;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
  background-color: #2980b9;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {display:block;}
```

```js
// When the user clicks on the button, toggle between hiding and showing the dropdown content
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
```

### On hover

```html
<div class="dropdown">
  <button class="dropbtn">Dropdown</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>
```

```css
/* Dropdown Button */
.dropbtn {
  background-color: #3498db;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
  background-color: #2980b9;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
  background-color: #2980b9;
}
```

### On hover with JS

```html
<div class="dropdown">
  <button class="dropbtn" onmouseover="myFunction()">Dropdown</button>
  <div class="dropdown-content" onmouseover="myFunction()">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>
```

```css
/* Dropdown Button */
.dropbtn {
  background-color: #3498db;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
  background-color: #2980b9;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
  background-color: #2980b9;
}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user moves the mouse over the dropdown button) */
.show {display:block;}
```

```js
// When the user moves the mouse over the button, open the dropdown content
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}
```

## Creating multiple dropdowns with the JS code(reusable)

```html
<div class="Car">
  <button class="dropbtn" onmouseover="myFunction('Car')">Car</button>
  <div class="dropdown-content" id="Car">
    <a href="#">BMW</a>
    <a href="#">Mercedes</a>
    <a href="#">Audi</a>
    </div>
</div>

<div class="Bike">
  <button class="dropbtn" onmouseover="myFunction('Bike')">Bike</button>
  <div class="dropdown-content" id="Bike">
    <a href="#">Honda</a>
    <a href="#">Yamaha</a>
    <a href="#">Suzuki</a>
  </div>
</div>
```

```js
// When the user moves the mouse over the button, open the dropdown content
function myFunction(id) {
  document.getElementById(id).classList.toggle("show");
}
```

# Mobile menus

## Hamburger menu

```html
<div class="hamburger-menu">
  <div class="line"></div>
  <div class="line"></div>
  <div class="line"></div>
</div>

<nav class="mobile-menu">
  <ul>
    <li><a href="#">Home</a></li>
    <li><a href="#">About</a></li>
    <li><a href="#">Services</a></li>
    <li><a href="#">Contact</a></li>
  </ul>
</nav>
```

```css
.hamburger-menu {
  width: 30px;
  height: 20px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  cursor: pointer;
}

.line {
  width: 100%;
  height: 2px;
  background-color: #000;
}

.mobile-menu {
  display: none;
}

.mobile-menu.open {
  display: block;
  /* Add styles for positioning and animations */
}

.line.close {
  transform: rotate(45deg);
  background-color: #fff;
}

.line.close:nth-child(2) {
  opacity: 0;
}

.line.close:nth-child(3) {
  transform: rotate(-45deg);
  background-color: #fff;
}
```

```js
const hamburgerMenu = document.querySelector('.hamburger-menu');
const mobileMenu = document.querySelector('.mobile-menu');

hamburgerMenu.addEventListener('click', () => {
  hamburgerMenu.classList.toggle('close');
  mobileMenu.classList.toggle('open');
});

document.addEventListener('click', (event) => {
  const target = event.target;
  const isMenuOpen = mobileMenu.classList.contains('open');

  if (isMenuOpen && !mobileMenu.contains(target) && !hamburgerMenu.contains(target)) {
    mobileMenu.classList.remove('open');
  }
});
```

# Image slider

```html
<div class="carousel-container">
  <div class="carousel-slides">
    <img src="image1.jpg" alt="Image 1">
    <img src="image2.jpg" alt="Image 2">
    <img src="image3.jpg" alt="Image 3">
  </div>

  <div class="carousel-navigation">
    <div class="prev-btn">&#8249;</div>
    <div class="next-btn">&#8250;</div>
  </div>

  <div class="carousel-indicators">
    <div class="indicator active"></div>
    <div class="indicator"></div>
    <div class="indicator"></div>
  </div>
</div>
```

```css
.carousel-container {
  position: relative;
  width: 100%;
  height: 400px;
  overflow: hidden;
}

.carousel-slides {
  display: flex;
  transition: transform 0.5s ease-in-out;
}

.carousel-slides img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.carousel-navigation {
  position: absolute;
  top: 50%;
  left: 10px;
  transform: translateY(-50%);
}

.carousel-navigation .prev-btn,
.carousel-navigation .next-btn {
  display: inline-block;
  width: 30px;
  height: 30px;
  background-color: #000;
  color: #fff;
  font-size: 24px;
  text-align: center;
  line-height: 30px;
  cursor: pointer;
}

.carousel-indicators {
  position: absolute;
  bottom: 10px;
  left: 50%;
  transform: translateX(-50%);
}

.carousel-indicators .indicator {
  display: inline-block;
  width: 10px;
  height: 10px;
  margin: 0 5px;
  background-color: #000;
  border-radius: 50%;
  cursor: pointer;
}

.carousel-indicators .indicator.active {
  background-color: #fff;
}
```

```js
const slidesContainer = document.querySelector('.carousel-slides');
const prevBtn = document.querySelector('.prev-btn');
const nextBtn = document.querySelector('.next-btn');
const indicators = document.querySelectorAll('.indicator');

let currentSlide = 0;
const slideWidth = slidesContainer.clientWidth;

// Go to the specified slide
const goToSlide = (slideIndex) => {
  slidesContainer.style.transform = `translateX(-${slideWidth * slideIndex}px)`;
  currentSlide = slideIndex;
  updateIndicators();
};

// Update the active indicator
const updateIndicators = () => {
  indicators.forEach((indicator, index) => {
    indicator.classList.toggle('active', index === currentSlide);
  });
};

// Navigate to the previous slide
const goToPrevSlide = () => {
  if (currentSlide === 0) {
    goToSlide(indicators.length - 1);
  } else {
    goToSlide(currentSlide - 1);
  }
};

// Navigate to the next slide
const goToNextSlide = () => {
  if (currentSlide === indicators.length - 1) {
    goToSlide(0);
  } else {
    goToSlide(currentSlide + 1);
  }
};

// Event listeners for arrow buttons
prevBtn.addEventListener('click', goToPrevSlide);
nextBtn.addEventListener('click', goToNextSlide);

// Event listener for indicator clicks
indicators.forEach((indicator, index) => {
  indicator.addEventListener('click', () => {
    goToSlide(index);
  });
});

// Auto
setInterval(goToNextSlide, 5000);
```


