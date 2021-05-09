package wooteco.subway.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import wooteco.subway.domain.line.Line;
import wooteco.subway.domain.section.Section;
import wooteco.subway.dto.LineResponse;
import wooteco.subway.dto.StationResponse;
import wooteco.subway.exceptions.LineDuplicationException;
import wooteco.subway.exceptions.LineNotFoundException;
import wooteco.subway.repository.LineDao;
import wooteco.subway.repository.SectionDao;
import wooteco.subway.repository.StationDao;

@Service
public class LineService {

    private final LineDao lineDao;
    private final StationDao stationDao;
    private final SectionDao sectionDao;

    public LineService(LineDao lineDao, StationDao stationDao, SectionDao sectionDao) {
        this.lineDao = lineDao;
        this.stationDao = stationDao;
        this.sectionDao = sectionDao;
    }

    public Line createLine(Line line) {
        validateDuplication(line.getName());
        long lindId = lineDao.save(line);
        line.setId(lindId);
        return line;
    }

    public List<Line> findAll() {
        return lineDao.findAll();
    }

    public Line findById(Long id) {
        return lineDao.findById(id)
            .orElseThrow(LineNotFoundException::new);
    }

    public void editLine(Line line) {
        validateDuplication(line.getName());
        lineDao.updateLine(line);
    }

    public void deleteLine(Long id) {
        lineDao.deleteById(id);
    }

    private void validateDuplication(String name) {
        boolean isDuplicated = lineDao.findAll()
            .stream()
            .anyMatch(line -> line.getName().equals(name));
        if (isDuplicated) {
            throw new LineDuplicationException();
        }
    }
}
