package com.imkiosk.imkiosk.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum BaseResponseStatus {

    /**
     * 200: 요청 성공
     **/
    SUCCESS(HttpStatus.OK, true, 200, "요청에 성공하였습니다."),

    NOT_EXIST_CONTENT(HttpStatus.NOT_FOUND, false, 201, "데이터가 없습니다."),

    /**
     * 400 : security 에러
     */
    WRONG_JWT_TOKEN(HttpStatus.UNAUTHORIZED, false, 401, "다시 로그인 해주세요"),
    NO_SIGN_IN(HttpStatus.UNAUTHORIZED, false, 402, "로그인을 먼저 진행해주세요"),
    NO_ACCESS_AUTHORITY(HttpStatus.FORBIDDEN, false, 403, "접근 권한이 없습니다"),
    DISABLED_USER(HttpStatus.FORBIDDEN, false, 404, "비활성화된 계정입니다. 계정을 복구하시겠습니까?"),
    FAILED_TO_RESTORE(HttpStatus.INTERNAL_SERVER_ERROR, false, 405, "계정 복구에 실패했습니다. 관리자에게 문의해주세요."),
    FAILED_CREATE_AUTHORITY(HttpStatus.FORBIDDEN, false, 406, "접근 권한 생성에 실패했습니다"),

    /**
     * 900: 기타 에러
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, 900, "Internal server error"),
    SSE_SEND_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, false, 901, "알림 전송에 실패하였습니다."),

    /**
     * 2000: users service error
     */
    // token
    TOKEN_NOT_VALID(HttpStatus.UNAUTHORIZED, false, 2001, "토큰이 유효하지 않습니다."),

    // Users
    DUPLICATED_USER(HttpStatus.CONFLICT, false, 2101, "이미 가입된 멤버입니다."),
    FAILED_TO_LOGIN(HttpStatus.UNAUTHORIZED, false, 2102, "아이디 또는 패스워드를 다시 확인하세요."),
    DUPLICATED_SOCIAL_USER(HttpStatus.CONFLICT, false, 2103, "이미 소셜 연동된 계정입니다."),
    DUPLICATED_SOCIAL_PROVIDER_USER(HttpStatus.CONFLICT, false, 2104, "계정에 동일한 플랫폼이 이미 연동되어있습니다"),
    NO_EXIST_USER(HttpStatus.NOT_FOUND, false, 2105, "존재하지 않는 멤버 정보입니다."),
    PASSWORD_SAME_FAILED(HttpStatus.BAD_REQUEST, false, 2106, "현재 사용중인 비밀번호 입니다."),
    PASSWORD_CONTAIN_NUM_FAILED(HttpStatus.BAD_REQUEST, false, 2107, "휴대폰 번호를 포함한 비밀번호 입니다."),
    PASSWORD_MATCH_FAILED(HttpStatus.BAD_REQUEST, false, 2108, "패스워드를 다시 확인해주세요."),
    NO_SUPPORTED_PROVIDER(HttpStatus.BAD_REQUEST, false, 2109, "지원하지 않는 플랫폼입니다"),
    DUPLICATED_NICKNAME(HttpStatus.CONFLICT, false, 2010, "이미 사용중인 닉네임입니다."),
    SAME_NICKNAME(HttpStatus.CONFLICT, false, 2011, "현재 사용중인 닉네임입니다."),
    INVALID_EMAIL_ADDRESS(HttpStatus.BAD_REQUEST, false, 2012, "이메일을 다시 확인해주세요."),
    DUPLICATED_EMAIL(HttpStatus.CONFLICT, false, 2013, "이미 사용중인 이메일입니다."),
    NO_EXIST_SIZE(HttpStatus.NOT_FOUND, false, 2018, "사용자 사이즈 정보가 존재하지 않습니다."),

    // Media
    NOT_EXIST_MEDIA(HttpStatus.NOT_FOUND, false, 2101, "존재하지 않는 미디어입니다."),
    ALREADY_EXIST_THUMBNAIL(HttpStatus.BAD_REQUEST, false, 2102, "썸네일이 이미 존재하는 컨텐츠입니다."),
    ALREADY_EXIST_LOGO(HttpStatus.BAD_REQUEST, false, 2103, "로고가 이미 존재하는 컨텐츠입니다."),
    FAILED_TO_GENERATE_MEDIA_CODE(HttpStatus.CONFLICT, false, 2104, "고유한 미디어 코드를 생성하는 데 실패했습니다."),
    INVALID_MEDIA_TYPE(HttpStatus.BAD_REQUEST, false, 2107, "미디어 타입을 다시 확인해주세요."),

    // Brand
    NOT_EXIST_BRAND(HttpStatus.NOT_FOUND, false, 2201, "존재하지 않는 브랜드입니다."),
    FAILED_TO_GENERATE_BRAND_CODE(HttpStatus.CONFLICT, false, 2204, "고유한 브랜드 코드를 생성하는 데 실패했습니다."),

    // Basket
    NOT_EXIST_BASKET_ITEM(HttpStatus.NOT_FOUND, false, 2301, "존재하지 않는 장바구니 품목입니다."),
    INVALID_PRODUCT_QUANTITY(HttpStatus.BAD_REQUEST, false, 2303, "상품 수량이 유효하지 않습니다."),
    FAILED_TO_GENERATE_BASKET_CODE(HttpStatus.BAD_REQUEST, false, 2304, "고유한 장바구니 코드를 생성하는 데 실패했습니다."),
    NOT_EXIST_PRODUCT_OPTION(HttpStatus.NOT_FOUND, false, 2305, "상품 옵션 코드를 다시 확인해주세요."),

    // Purchase
    INVALID_PURCHASE_QUANTITY_OR_PRICE(HttpStatus.BAD_REQUEST, false, 2353, "상품 수량 또는 금액이 유효하지 않습니다."),
    FAILED_TO_GENERATE_PURCHASE_CODE(HttpStatus.BAD_REQUEST, false, 2354, "고유한 주문 코드를 생성하는 데 실패했습니다."),

    // Category
    NOT_EXIST_CATEGORY(HttpStatus.NOT_FOUND, false, 2401, "존재하지 않는 카테고리입니다."),
    ALREADY_EXIST_CATEGORY_NAME(HttpStatus.BAD_REQUEST, false, 2402, "이미 존재하는 카테고리명입니다."),
    NOT_EXIST_PARENT_CATEGORY(HttpStatus.BAD_REQUEST, false, 2403, "존재하지 않는 상위 카테고리입니다."),
    FAILED_TO_GENERATE_CATEGORY_CODE(HttpStatus.CONFLICT, false, 2404,
        "고유한 카테고리 코드를 생성하는 데 실패했습니다."),
    FAILED_TO_UPDATE_CATEGORY(HttpStatus.BAD_REQUEST, false, 2405, "부모 카테고리를 업데이트 할 수 없습니다."),
    FAILED_TO_DELETE_CATEGORY(HttpStatus.BAD_REQUEST, false, 2406, "하위 카테고리가 있어서 삭제할 수 없습니다."),

    // Product-Category
    NOT_EXIST_IN_PRODUCT_CATEGORY(HttpStatus.NOT_FOUND, false, 2409,
        "Product-Category-List 테이블에 존재하지 않는 상품입니다."),

    // Address
    NOT_DELETE_DEFAULTADDRESS(HttpStatus.BAD_REQUEST, false, 2410, "기본배송지는 삭제할 수 없습니다."),
    NOT_FOUND_ADDRESS(HttpStatus.BAD_REQUEST, false, 2411, "배송지를 찾을 수 없습니다."),
    // Interest
    NO_EXIST_INTEREST(HttpStatus.NOT_FOUND, false, 2501, "존재하지 않는 관심사입니다."),

    /**
     * 3000: product service error
     */

    // Shorts
    NO_EXIST_PRODUCT(HttpStatus.NOT_FOUND, false, 3001, "존재하지 않는 상품입니다"),
    NO_EXIST_OPTION(HttpStatus.NOT_FOUND, false, 3002, "존재하지 않는 옵션입니다"),
    NO_EXIST_REVIEW(HttpStatus.NOT_FOUND, false, 3003, "리뷰가 존재하지 않습니다."),
    NO_EXIST_REVIEWSTATISTIC_NAME(HttpStatus.NOT_FOUND, false, 3004, "리뷰 평가항목이 존재하지 않습니다."),
    NO_EXIST_REVIEWSTATISTIC_VALUE(HttpStatus.NOT_FOUND, false, 3005, "리뷰 평가항목에 대한 값이 존재하지 않습니다."),
    ALREADY_EXIST_PRODUCT_CODE(HttpStatus.NOT_FOUND, false, 3007, "이미 존재하는 상품코드입니다."),






    ;

    private final HttpStatusCode httpStatusCode;
    private final boolean isSuccess;
    private final int code;
    private final String message;

}
