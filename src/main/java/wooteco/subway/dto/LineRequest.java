package wooteco.subway.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import wooteco.subway.domain.line.Line;
import wooteco.subway.dto.validator.Name;
import wooteco.subway.dto.validator.StationForSection;

public class LineRequest {

    @Name
    private String name;
    @NotBlank
    private String color;
    @StationForSection
    private Long upStationId;
    @StationForSection
    private Long downStationId;
    @Positive(message = "1 이상의 거리를 입력해 주세요.")
    private int distance;

    public LineRequest() {
    }

    public LineRequest(String name, String color, Long upStationId, Long downStationId,
        int distance) {
        this.name = name;
        this.color = color;
        this.upStationId = upStationId;
        this.downStationId = downStationId;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
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

    public Line toLine(Long id) {
        return new Line(id, name, color);
    }

    public Line toLine() {
        return new Line(name, color);
    }
}
