## 지하철 정보 관리
### 1단계 - 지하철 노선 / 인수 테스트
- [x] 노선 CRUD
    - [x] 노선 추가 POST : "/lines"
    - [x] 노선 목록 조회 GET : "/lines"
    - [x] 노선 조회 GET : "/lines/{id}"
    - [x] 노선 수정 PUT : "/lines/{id}"
    - [x] 노선 제거 DELETE : "/lines/{id}"
    
### 2단계 - 지하철 노선 / 페이지
- [x] 노선 목록 조회 
    - [x] 페이지 호출 시 미리 저장한 지하철 노선 조회
    - [x] 지하철 노선 목록 조회 API 사용
- [x] 노선 추가
    - [x] 노선 추가 버튼을 누르면 아래와 같은 팝업화면이 뜸
    - [x] 노선 이름과 정보를 입력
    - [x] 지하철 노선 추가 API 사용
- [x] 노선 상세 정보 조회
    - [x] 목록에서 노선 선택 시 상세 정보를 조회
- [x] 노선 수정
    - [x] 목록에서 우측 수정 버튼을 통해 수정 팝업화면 노출
    - [x] 수정 팝업 노출 시 기존 정보는 입력되어 있어야 함
    - [x] 정보 수정 후 지하철 노선 수정 API 사용
- [x] 노선 삭제
    - [x] 목록에서 우측 삭제 버튼을 통해 삭제
    - [x] 지하철 노선 삭제 API 사용
- [ ] 프론트 유효성 검증
    -  [ ] 추가
    -  [ ] 수정
    
### 3단계 노선별 지하철역 / 인수 테스트
- [x] 지하철 노선에 역 추가
    - [x] 노선에 지하철 역이 추가될 경우 아래의 정보가 추가되어야 함
    - [x] 이전역과의 거리
    - [x] 이전역과의 소요시간
- [x] 지하철 노선의 지하철역 목록 조회
- [x] 지하철 노선에 역 제거
    - [x] 노선과 제거할 지하차철역 식별값을 전달

### 4단계 노선별 지하철역 / 로직
- [x] 지하철 노선에 역 추가
    - [x] 마지막 역이 아닌 뒷 따르는 역이 있는경우 재배치를 함
    - [x] 노선에 A - B - C 역이 연결되어 있을 때 B 다음으로 D라는 역을 추가할 경우 A - B - D - C로 재배치 됨
- [ ] 지하철 노선에 역 제거
    - [ ] 출발역이 제거될 경우 출발역 다음으로 오던 역이 출발역으로 됨
    - [ ] 중간역이 제거될 경우 재배치를 함
        - [ ] 노선에 A - B - D - C 역이 연결되어 있을 때 B역을 제거할 경우 A - B - C로 재배치 됨