package za.ac.cput.repository;

import za.ac.cput.domain.Position;

import java.util.HashSet;
import java.util.Set;

public class PositionRepository implements IRepository<Position, String> {
    private static PositionRepository repository = null;
    private final Set<Position> positions;

    private PositionRepository() {
        this.positions = new HashSet<>();
    }

    public static PositionRepository getRepository() {
        if (repository == null) {
            repository = new PositionRepository();
        }
        return repository;
    }

    @Override
    public Position create(Position position) {
        this.positions.add(position);
        return position;
    }

    @Override
    public Position read(String positionCode) {
        return findByPositionCode(positionCode);
    }

    @Override
    public Position update(Position position) {
        Position oldPosition = findByPositionCode(position.getPositionCode());
        if (oldPosition != null) {
            this.positions.remove(oldPosition);
            this.positions.add(position);
            return position;
        }
        return null;
    }

    @Override
    public boolean delete(String positionCode) {
        Position position = findByPositionCode(positionCode);
        if (position != null) {
            this.positions.remove(position);
            return true;
        }
        return false;
    }

    @Override
    public Set<Position> getAll() {
        return this.positions;
    }

    private Position findByPositionCode(String positionCode) {
        return this.positions.stream()
                .filter(position -> position.getPositionCode().equals(positionCode))
                .findAny()
                .orElse(null);
    }
}
