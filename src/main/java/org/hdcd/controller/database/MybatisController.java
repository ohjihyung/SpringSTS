package org.hdcd.controller.database;


public class MybatisController {
	/**
	 *   12장 마이바티스 (p514)
	 *   
	 *   
	 *   1.마이바티스란
	 *   
	 *      1) What?
	 *      마이바티스는 자바 퍼시스턴스 프레임워크의 하나로 XML 서술자나 어노테이션을 사용하여 
	 *      저장 프로시저나 SQL문으로 객체들을 연결시킨다.
	 *      
	 *      지속성 프레임워크(Persistence Framework)는 
	 *      데이터의 저장, 조회, 변경, 삭제를 다루는 클래스 및 설정 파일들의 집합이다.
	 *      
	 *      
	 *      마이바티스는 Apache 라이센스 2.0으로 베포되는 자유 소프트웨어
	 *      
	 *      
	 *      
	 *      2)마이바티스를 사용함으로서 얻을 수 있는 이점
	 *      
	 *         - SQL의 체계적인 관리
	 *         - 자바 객체와 SQL 입출력 값의 투명한 바인딩
	 *         - 동적 SQL 조합
	 *      
	 *      
	 *      3) 마이바티스 설정
	 *         
	 *              3-1) 의존 관계 정의
	 *                - mybatis
	 *                - mybatis-spring 
	 *                - spring-jdbc
	 *                - commons-dbcp2
	 *                - log4jdbc-log4j2-jdbc4
	 *                - ojdbc6
	 *                
	 *                 > 의존 관계 정의 후 Maven > update Project를 진행한다.
	 *                 
	 *                  *** 그런데 에러가 나??....
	 *                    -1). Maven 라이브러리 부분에 내가 추가한 라이브러리 잘 있는지 확인
	 *                    
	 *                     2) Project Clean
	 *                         > 여기까지 하면 해결됨
	 *                    
	 *                     3) 이클립스 껐다 킨다.
	 *                    
	 *                     4) 오타 확인(pom.xml)
	 *                     
	 *                     5) 프로젝트 Preference 열고, 빌드 패스 확인
	 *                     6) 프로젝트 Preference 열고, Java Facet 확인
	 *                      
	 *                     7) window > showview > markers 뷰 활성화하고 에러 삭제
	 *                     8) project Clean
	 *                      - 에러 해결 짜잔
	 *                    
	 *                
	 *              3-2) 스프링과 마이바티스 연결 설정
	 *                - root-context.xml 설정
	 *                  > dataSource
	 *                  > sqlSessionFactory
	 *                  > sqlSessionTemplate
	 *                  > basePackage
	 *                  
	 *              
	 *              
	 *              3-3) 마이바티스 설정
	 *              - WEB-INF/mybatisAlias/mybatisAlias.xml 설정
	 *              - 마이바티스의 위치 설정은 root-context의 'sqlSessionFactory'를 설정할 때 property 요소로 적용
	 *              
	 *       
	 *     4) 테이블 생성
	 *     
	 *           4-1 ) board, member, member_auth 테이블 생성 
	 *   
	 *    
	 *    
	 *    2. Mapper 인터페이스
	 *     - 인터페이스의 구현을 mybatis-spring 에서 자동으로 생성할 수 있다.
	 *     
	 *        1) 마이바티스 구현
	 *        
	 *            1-1) Mapper 인터페이스
	 *            - BoardMapper.java 생성
	 *            
	 *            1-2) Mapper 인터페이스와 매핑할 Mapper
	 *              - sqlmap/boardMapper_SQL.xml
	 *              	> namespace를 설정했는데, 그 namespace는 BoardMapper 인터페이스의 경로로 지정(패키지명을 포함한 경로)
	 *                  > _SQL.xml안에 있는 쿼리를 실행하기 위해서 namespace를 통해 위치를 찾고자 설정함.
	 *                  
	 *            
	 *         		1-3) 게시판 구현 설명
    *            - 게시판 컨트롤러 만들기 (board/CrudBoardController)
    *            - 게시판 등록 화면 컨트롤러 메소드 만들기 (crudRegister:get)
    *            - 게시판 등록 화면 만들기 (crud/register.jsp)
    *            - 게시판 등록 기능 컨트롤러 메소드 만들기 (crudRegister:post)
    *            - 게시판 등록 서비스 인터페이스 메소드 만들기
    *            - 게시판 등록 기능 서비스 클래스 만들기
    *            - 게시판 등록 기능 Mapper 인터페이스 메소드 만들기
    *            - 게시판 등록 가능 Mapper xml 쿼리 만들기
    *            - 게시판 등록 완료 페이지 만들기
    *            - 게시판 목록 화면 컨트롤러 메소드 만들기 (crudList:get)
    *            - 게시판 목록 화면 서비스 인터페이스 메소드 만들기
    *            - 게시판 목록 화면 서비스 클래스 메소드 만들기
    *            - 게시판 목록 화면 Mapper 인터페이스 만들기
    *            - 게시판 목록 화면 Mapper xml 쿼리 만들기
	 *           - 게시판 목록 화면 만들기 (crud/list.jsp)
	 *           -       여기서 한번 기능 및 화면을 체크
	 *           -  게시판 상세 화면 컨트롤러 메소드 만들기
	 *           -  게시판 상세 화면 서비스 인터페이스 메소드 만들기
	 *           -  게시판 상세 화면 서비스 클래스 메소드 만들기
	 *           -  게시판 상세 화면 Mapper 인터페이스 메서드 만들기 
	 *           -  게시판 상세 화면 Mapper xml 쿼리 만들기 
	 *           -  게시판 상세 화면 만들기 (crud/read.jsp)
	 *           -      여기서 한번 기능 및 화면을 체크  
	 *           - 게시판 수정화면 컨트롤러 메소드 만들기 (crudModify:get)
	 *           - 게시판 수정화면 서비스 인터페이스 메소드 만들기
	 *           - 게시판 수정화면 서비스 클래스 메소드 만들기
	 *           - 게시판 수정화면 Mapper 인터페이스 메소드 만들기
	 *           - 게시판 수정화면 Mapper xml 쿼리 만들기
	 *           - 게시판 수정화면 만들기(crud/register.jsp -status 'u' 전달)
	 *           - 게시판 수정 기능 컨트롤러 메소드 만들기 (crudModify:post)
	 *           - 게시판 수정 기능 서비스 인터페이스 메소드 만들기
	 *           - 게시판 수정 기능 서비스 클래스 메소드 만들기
	 *           - 게시판 수정 기능 Mapper 인터페이스 메서드 만들기
	 *           - 게시판 수정 기능 Mapper xml 쿼리 만들기
	 *           -           여기서 한번 기능 및 화면 체크!
	 *           -  게시판 삭제 기능 컨트롤러 메소드 만들기 (crudRemove:post)
	 *           -  게시판 삭제 기능 서비스 인터페이스 메소드 만들기
	 *           - 게시판 삭제 기능 서비스 클래스 메소드 만들기
	 *           - 게시판 삭제 기능 Mapper 인터페이스 메소드 만들기
	 *           - 게시판 삭제 기능 Mapper xml 쿼리 만들기
	 *                       여기서확인
	 *                       
	 *           - 기본적인 CRUD 끝
	 *       3. 별칭 적용 
	 *       - TypeAlias로 매핑 파일에서 반복적으로 사용될 패키지의 이름을 정의한다.
	 *       
	 *          1)마이바티스 설정
	 *              
	 *            1-1) mybatisAlias.xml 설정
	 *                -typeAlias 설정을 한다.
	 *              
	 *                
	 *            1-2) boardMapper_SQL.xml 수정
	 *              - 쿼리 태그에 각각 셋팅한 패키지명 대신 alias로 설정한 별칭으로 대체한다.
	 *          
	 *           
	 *             
	 *      4. _로 구분된 컬럼명 자동 매핑
	 *      
	 *      - 마이바티스 설정의 maxUnderscoreToCamelCase 프로퍼티 값을 true로 지정하면 _로 구분된 컬러명을 소문자 낙타표기법의 프로퍼티명으로 
	 *      자동 메핑할 수 있음
	 *      
	 *      
	 *        '_' 포함되어 있는 데이터베이스 컬럼명으 카멜기법 셋팅으로 인해서 bo_no가 boNo로 처리된다
	 *        
	 *        
	 *        1) 마이바티스 설정
	 *           
	 *             1-1) mybatisAlias.xml 설정
	 *             
	 *              - <setting name="mapUnderscoreToCamelCase" value ="true"/> 설정 추가
	 *              - </settings>
	 *              
	 *              
	 *              1-2) 매핑 파일 수정 (boardMapper_SQL.xml)
	 *                - read 부분에서 as boardNo , as regDate 삭제
	 *                - list 부분에서 as boardNo , as regDate 삭제
	 *       
	 *       
	 *       5. 기본기 취득 
	 *       - 마이바티스는 useGeneratedKeys 속성을 이용하여 INSERT 할 때 데이터베이스 측에서 체변된 기본키를
	 *       취득할 수 있다.
	 *       
	 *         1) 데이터베이스 테이블 준비
	 *         
	 *           1-1) 위에서 회원테이블  만들어 놓음 
	 *           
	 *               - member
	 *               - member_auth
	 *               - 2개의 테이블을 미리준비 해놓음
	 *               
	 *         2) 마이바티스 설정
	 *         
	 *           
	 *            2-1) 매핑 파일 수정 (boardMapper_SQL.xml)
	 *             - create 부분에서 속성 추가
	 *               > useGeneratedKeys = "true" keyProperty="boardNo"
	 *               > <selectKey order ="BEFORE" resultType="int" keyProperty="boardNo">
	 *               >   select seq_board.nextval from dual
	 *               
	 *               >  </selectKey>
	 *               > insert into board (
	 *               >	 board_no, title, content, writer, reg_date
	 *               >	)	
	 *               > values(
	 *               	  #{boardNo}, #{title}, #{content}, #{writer}, sysdate
	 *               > )
	 *              
	 *           
	 *              **** currval 사용시 주의점 
	 * 
	 *                - select seq_board.currval from dual
	 *                위 select 쿼리를 사용시, currval를 사용하는데 있어 사용 불가에 대한 에러 발생할 수 있다,
	 *                
	 *                currval를 사용할 때는 select seq_board.nextval from dual로 먼저 한번 실행 후,
	 *                select seq_board.nextval from dual로 사용하면 에러가 없음
	 *      
	 *         			*** 대체 할 쿼리
	 *                   - select last_number from user_sequences where sequence_name = "seq_board"   ===  시퀀스의 마지막번호 가져옴 
	 *                  
	 *            2-2)  컨트롤러 메소드에서 crudRegister 부분 수정
	 *            
	 *               - 전달받은 시퀀스가 boardNo에 들어있기 때문에 , 등록 후 전달받은 boardNo로 상세보기 화면으로 접근하도록 하기
	 *               
	 *               
	 *           
	 *               
	 *       6.  일대 다 관계 테이블 매핑
	 *       
	 *        - 마이바티스 기능을 활용하여 매핑 파일을 적절하게 정의하면 일대 다 관계 태이블 매핑을 쉽게 처리할 수 있다.
	 *        
	 *           ex) Member 클래스 안에 Address 클래스가 있다.
	 *                  - Member 
	 *                          - Address
	 *                                 > location
	 *                                 > postCode
	 *                     
	 *                     
	 *                  Member 클래스 안에 List<Address> 컬랙션이 있다.
	 *                  
	 *                  Member 
	 *                      - List
	 *                          - Address
	 *                          - Address
	 *                          .....
	 *                          
	 *                      
	 *                     이런 경우에 브라우저에서 입력받아 넘기는 데이터가 서버로 전송 되고, 전송된 계층 데이터들이 
	 *                     내가 처리해야할 데이터 매핑 공간에 하나나씩 잘 세팅되어야한다.
	 *                      
	 *                  
	 *            
	 *               
	 *               
	 *          1)  게시판 구현 설명 
	 *          
	 *                   -회원 등록 화면 컨트롤러 만들기(member/CrudMemberController)
	 *                   -회원 등록 화면 띄우기위한 컨트롤러 메소드 만들기 (crudMemberRegisterForm:get )
	 *                   -회원 등록 화면 만들기 (crud/member/register.jsp)
	 *                   -회원 등록 기능 컨트롤러 메소드 만들기 (crudMemberRegister:post)
	 *                   -회원 등록 기능 인터페이스 메소드 만들기
	 *                   -회원 등록 기능 클래스 메소드 만들기
	 *                   -회원 등록 기능 Mapper 인터페이스 메소드 만들기
	 *                   -회원 등록 기능 Mapper xml 쿼리 만들기
	 *                   -회원 등록 완료 페이지 만들기(crud/member/success.jsp)
	 *                        -- 여기까지 확인
	 *                        
	 *                   -회원 목록 화면 컨트롤러 메소드 만들기 (crudMemberList:get)
	 *                   -회원 목록 화면 서비스 인터페이스 메소드 만들기
	 *                   -회원 목록 화면 서비스 클래스 메서드 만들기
	 *                   -회원 목록 화면 Mapper xml 쿼리 만들기
	 *                   -회원 목록 화면 페이지 만들기(crud/member/list.jsp)
	 *          		 -    여기 까지 확인
	 *          
	 *                   - 회원 상세 화면 컨트롤러 메서드 만들기(crudMemberRead:get)
	 *                   - 회원 상세 화면 서비스 인터페이스 만들기
	 *                   - 회원 상세 화면 서비스 클래스
	 *                   - 회원 상세 Mapper 인터페이스
	 *                   - 회원 상세 Mapper.xml 쿼리
	 *                   - 회원 상세 화면 만들기 (crud/member/read)
	 *                	 
	 *                	 - 회원 수정 화면 컨트롤러 메소드 만들기
	 *                	 - 회원 수정 화면 서비스 인터페이스
	 *                	 - 회원 수정 화면 서비스 클래스
	 *                   - 회원 수정 Mapper 인터페이스
	 *                   - 회원 수정 Mapper.xml 쿼리
	 *                   - 회원 수정 완료 화면 만들기 (이미 만들어진것으로 확인)
	 *                	  
	 *                
	 *                   - 회원 삭제 화면 컨트롤러 메서드 만들기(crudMemberDelete:post)
	 *                   - 회원 삭제 화면 서비스 인터페이스 만들기
	 *                   - 회원 삭제 화면 서비스 클래스
	 *                   - 회원 삭제 Mapper 인터페이스
	 *                   - 회원 삭제 Mapper.xml 쿼리
	 *                   - 회원 삭제 완료 페이지 화면 만들기 (이미 만들어진것으로 확인)
	 *                	 
	 *                   
	 *      7.  동적 sql
	 *      
	 *        - 마이바티스는 동적 SQL을 조립하는 구조를 지원하고 있으며, sql 조립 규칙을 매핑 파일에 정의할 수 있다.
	 *        
	 *               1) 동적으로 sql을 조립하기 위한 sql 요소
	 *                  - <where>
	 *                    > where 절 앞 뒤에 내용을 더 추가하거나 삭제할 때 사용하는 요소
	 *                    
	 *                  -<if>
	 *                    > 조건을 만족할 때만 sql 조립할 수 있게 만드는 요소
	 *                    
	 *                  -<choose>
	 *                    >여러 선택 항목에서 조건에 만족할 때만 sql을 조립할 수 있게 만드는 요소
	 *                    
	 *                  -<foreach>
	 *                     > 컬랙션이나 배열에 대해 반복 처리를 하기 위한 요소
	 *                  
	 *                  -<set>
	 *                     > SET 절 앞 뒤에 내용을 더 추가하거나 삭제할 때 사용하는 요소
	 *                 
	 *                 
	 *               2)  게시판 구현 설명 
	 *               
	 *                  - 게시판 목록 화면 검색 페이지 추가 (crud/board/list.jsp)
	 *                  
	 * 
	 *              
	 *          ==========================부트스트랩을 이용한 crud 진행 -======================
	 *          
	 *              
	 *               패이지 모듈화를 위한 Tiles를 함께 사용하여 crud를 진행합니다.
	 *               
	 *              1. Tiles란
	 *                - 어떤 jsp를 탬플릿으로 사용하고 탬플릿의 각 영역을 어떤 내용으로 채울지에 대한 정보를 설정
	 *                - 하나의 화면들을 만들다보면 공통적으로 반복적으로 생성해야하난 header,footer와 같은 영역들이 존재합니다.
	 *                우리는 그러한 공통부들을 분리하여 반복적으로 컴포넌트들을 사용하는게 아닌 공통적인 부분은 한번만 가져다 쓰고
	 *                변화하는 부분에 대해서만 동적으로 변환해 페이지를 관리 할 수 있어야 할 것입니다.
	 *                이렇게 ,  header/footer/menu 등등 공통적인 소스를 분리하여 한 화면에서 동적으로 레이아웃을 한 곳에 
	 *                배치하여 설정하고 관리할 수 있도록 도와주는 페이즈 모듈화를 돕는 프레임워크가 Tiles
	 *                
	 *                - 아래 jsp들을 이용하여 페이지 모듈화를 진행
	 *                 > template.jsp 
	 *                     > footer.jsp
	 *                     > content source
	 *                     > footer.jsp
	 *               
	 *               
	 *              2. Tiles Layout 구현 설명
	 *                  
	 *                   1) Tiles 의존 관계 등록
	 *                       - tiles-core
	 *                       - tiles-api
	 *                       - tiles-servlet
	 *                       - tiles-jsp
	 *                       
	 *                      @@ 의존 관계 등록후 Maven > udate Project
	 *                
	 *              
	 *             		 2) servlet-content.xml 수정
	 *                         -ViewResolver order 순서 2순위로 지정
	 *                         -tilesViewResolver Bean 등록 진행
	 *          
	 *      
	 *             3. 공지사항 게시판(부트스트랩 디자인) 실습
	 *             
	 *                 3-1) 데이터베이스 준비
	 *                    - notice 테이블 생성
	 *                    create table notice(
							    bo_no number(8) not null,
							    bo_title varchar2(300) not null,
							    bo_content varchar2(4000) not null,
							    bo_writer varchar2(300) not null,
							    bo_date date not null,
							    bo_hit number(8) default 0 null,
							    constraint pk_notice primary key(bo_no)
							);

							create sequence seq_notice increment by 1 start with 1 nocache
	 *               
	 *                    
	 *                 3-2) 게시판 작성
	 *                   - 게시판 목록, 상세보기 컨트롤러 만들기 (noticeboard/NoticeRetrieveController)
	 *                   - 게시판 목록 화면 컨트롤러 메소드 만들기 (noticeListView: get)
	 *                   - 게시판 목록 화면 만들기 (noticeboard/list.jsp)
	 *                   -        여기까지 Tiles로 페이지 모듈화 확인
	 *                   -  게시판 등록 컨트롤러 만들기(noticeboard/NoticeInsertController)
	 *                   -  게시판 등록 화면 컨트롤러 메소드 만들기 (noticeFormView:get)
	 *                   -  게시판 등록 화면 만들기 (noticeboard/form.jsp)
	 *                   -        여기까지 확인
	 *                   - 게시판 등록 기능 컨트롤러 메소드 만들기(noticeInsert:post)
	 *                   - 게시판 등록 기능 서비스 인터페이스 메소드 만들기
	 *                   - 게시판 등록 기능 서비스 클래스 메소드 만들기
	 *                   - 게시판 등록 기능 mapper 인터페이스 메소드 만들기
	 *                   - 게시판 등록 기능 Mapper.xml 쿼리 만들기
	 */
}
