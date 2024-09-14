package domain.models.entities.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.DayOfWeek;

@Converter
public class DiaSemanaAttributeConverter implements AttributeConverter<DayOfWeek, String> {

  @Override
  public String convertToDatabaseColumn(DayOfWeek dayOfWeek) {
    return switch (dayOfWeek) {
      case MONDAY -> "Lunes";
      case TUESDAY -> "Martes";
      case WEDNESDAY -> "Miércoles";
      case THURSDAY -> "Jueves";
      case FRIDAY -> "Viernes";
      case SATURDAY -> "Sábado";
      case SUNDAY -> "Domingo";
    };
  }

  @Override
  public DayOfWeek convertToEntityAttribute(String s) {
    return switch (s) {
      case "Lunes" -> DayOfWeek.MONDAY;
      case "Martes" -> DayOfWeek.TUESDAY;
      case "Miércoles" -> DayOfWeek.WEDNESDAY;
      case "Jueves" -> DayOfWeek.THURSDAY;
      case "Viernes" -> DayOfWeek.FRIDAY;
      case "Sábado" -> DayOfWeek.SATURDAY;
      case "Domingo" -> DayOfWeek.SUNDAY;
      default -> throw new IllegalArgumentException("Unknown day: " + s);
    };
  }
}
