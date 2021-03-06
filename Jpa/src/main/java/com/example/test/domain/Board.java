package com.example.test.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Board {
	
	/**
	 * Entity
	 *  테이블과 링크될 클래스임을 나타낸다.
	    기본값으로 크래스의 카멜케이스 이름을 언더 스커어 네이밍(_)으로 테이블 이름을 매칠한다.
	    ex) SalesManager.java 에서 sales_manager table 로
	    
	   GeneratedValue
	    PK 생성 규칙
	    스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.
	   
	   Id
	    해당 테이블의 PK 필드를 나타낸다.
	   
	   Column
		테이블의 컬럼을 나타내며 굳이 선언하지 않더라고 해당 클래스의 필드는 모두 컬럼이 된다.
		사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵셥이 있으면 사용한다.
		
	   Builder
		해당 클래스의 빌더 패턴 클래스를 생성
		생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
		
		Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    
    public void update(String title, String content) {
    	this.title = title;
    	this.content = content;
    }

}
