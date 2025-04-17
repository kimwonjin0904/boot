$(document).ready(function() {

    // var newImageUrl = "/static/" + getRandomInt(1, 46) + ".png";

    // .cart-page-outside 클래스의 background 속성 업데이트
    $(".cart-page-outside").css("background", `#c72320 url("../static/img/1.webp") no-repeat center`);
    $(".cart-page-outside").css("background-size", "cover");
    $(".cart-page-outside").css("width", "100%");
    $(".cart-page-outside").css("height", "100%");


    var isCardOpened = false; // 첫 번째 클릭 여부를 확인하는 플래그 변수
    var $clickMe = $('.click-icon'),
        $card = $('.card');
    
    $card.on('click', function() {
            $(this).toggleClass('is-opened');
            $clickMe.toggleClass('is-hidden');
      });
  });
 