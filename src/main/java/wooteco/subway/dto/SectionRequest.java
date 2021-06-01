package wooteco.subway.dto;

import javax.validation.constraints.Positive;
import wooteco.subway.dto.validator.StationForSection;

public class SectionRequest {

    @StationForSection
    private Long upStationId;
    @StationForSection
    private Long downStationId;
    @Positive(message = "1 이상의 거리를 입력해 주세요.")
    private int distance;

    public SectionRequest() {
    }

    public SectionRequest(Long upStationId, Long downStationId, int distance) {
        this.upStationId = upStationId;
        this.downStationId = downStationId;
        this.distance = distance;
    }

    public Long getUpStationId() {
        return upStationId;
    }

    public Long getDownStationId() {
        return downStationId;
    }

    public int getDistance() {
        return distance;
    }
}
