package java8;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAdjusters;

public class DateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate localDate = LocalDate.now(); //represents only a date.
		System.out.println("LocalDate\n"+localDate.toString());                
		System.out.println(localDate.getDayOfWeek().toString()); 
		System.out.println(localDate.getDayOfMonth());           
		System.out.println(localDate.getDayOfYear());            
		System.out.println(localDate.isLeapYear());              
		System.out.println(localDate.plusDays(12).toString());   
		
		
		LocalTime localTime = LocalTime.of(3, 20);  //The LocalTime class represents only a time
		System.out.println("LocalTime\n"+localTime.toString());
		System.out.println(localTime.getHour());
		System.out.println(localTime.getMinute());
		System.out.println(localTime.getSecond());
		System.out.println(localTime.MIDNIGHT);
		System.out.println(localTime.NOON);
		
		
		LocalDateTime localDateTime = LocalDateTime.now();  //class represents a date-time. There is no representation of a time-zone.
		System.out.println("LocalDateTime\n"+localDateTime.toString());      
		System.out.println(localDateTime.getDayOfMonth()); 
		System.out.println(localDateTime.getHour());       
		System.out.println(localDateTime.getNano());
		
		OffsetDateTime offsetDateTime = OffsetDateTime.now();//OffsetDate, OffsetTime, OffsetDateTime gives with Timezone 
		System.out.println("OffsetDateTime\n"+offsetDateTime.toString());             
		 
		offsetDateTime = OffsetDateTime.now(ZoneId.of("+05:30"));
		System.out.println(offsetDateTime.toString());              //2013-05-15T10:10:37.258+05:30
		 
		offsetDateTime = OffsetDateTime.now(ZoneId.of("-06:30"));
		System.out.println(offsetDateTime.toString());              //2013-05-14T22:10:37.258-06:30
		 
		ZonedDateTime zonedDateTime = 
		                ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(zonedDateTime.toString());   
		
		Instant instant = Instant.now();// represents an instant in time to an accuracy of nanoseconds
		System.out.println("Instant time\n"+instant.toString());                                 
		System.out.println(instant.plus(Duration.ofMillis(5000)).toString());   
		System.out.println(instant.minus(Duration.ofMillis(5000)).toString());  
		System.out.println(instant.minusSeconds(10).toString()); 
		
		Duration duration = Duration.ofMillis(5000);//the time difference between two time stamps.
		System.out.println("Duration \n"+duration.toString());     
		 
		duration = Duration.ofSeconds(60);
		System.out.println(duration.toString());     
		 
		duration = Duration.ofMinutes(10);
		System.out.println(duration.toString());     
		 
		duration = Duration.ofHours(2);
		System.out.println(duration.toString());     
		 
		duration = Duration.between(Instant.now(), Instant.now().plus(Duration.ofMinutes(10)));
		System.out.println(duration.toString()); 
		
		
		Period period = Period.ofDays(6);//To interact with human, you need to get bigger durations
		System.out.println("Period\n"+period.toString());    
		 
		period = Period.ofMonths(6);
		System.out.println(period.toString());    
		 
		period = Period.between(LocalDate.now(), 
		            LocalDate.now().plusDays(60));
		System.out.println(period.toString());  
		
		
		System.out.println("Day of Week\n"+DayOfWeek.of(2));                    //TUESDAY 
		 
		DayOfWeek day = DayOfWeek.FRIDAY;
		System.out.println(day.getValue());                     //5
		 
		LocalDate localDat = LocalDate.now();
		System.out.println(localDat.with(DayOfWeek.MONDAY)); 
		
		
		LocalDate date = LocalDate.of(2013, Month.MAY, 15);                     //Today
        
		LocalDate endOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("TemporalAdjusters \n"+endOfMonth.toString());                              //2013-05-31
		 
		LocalDate nextTue = date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println(nextTue.toString());   
		
		//Builder pattern used to make date object
		 OffsetDateTime date1 = Year.of(2013)
		                        .atMonth(Month.MAY).atDay(15)
		                        .atTime(0, 0)
		                        .atOffset(ZoneOffset.of("+03:00"));
		 System.out.println("BuilderPattern : "+date1);                                     //2013-05-15T00:00+03:00
		 
		//factory method used to make date object
		OffsetDateTime date2 = OffsetDateTime.
		                        of(2013, 5, 15, 0, 0, 0, 0, ZoneOffset.of("+03:00"));
		System.out.println("FactoryMethod :"+date2);  
		
		Clock clock = Clock.systemDefaultZone();
		System.out.println(clock);                      //SystemClock[Asia/Calcutta]
		System.out.println(clock.instant().toString()); //2013-05-15T06:36:33.837Z
		System.out.println(clock.getZone());            //Asia/Calcutta
		 
		Clock anotherClock = Clock.system(ZoneId.of("Europe/Paris"));
		System.out.println(anotherClock);                       //SystemClock[Europe/Tiraspol]
		System.out.println(anotherClock.instant().toString());  //2013-05-15T06:36:33.857Z
		System.out.println(anotherClock.getZone());             //Europe/Tiraspol
		 
		Clock forwardedClock  = Clock.tick(anotherClock, Duration.ofSeconds(600));
		System.out.println(forwardedClock.instant().toString()); 
		
		DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder();
		formatterBuilder.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
		                .appendLiteral("-")
		                .appendZoneOrOffsetId();
		DateTimeFormatter formatter = formatterBuilder.toFormatter();
		System.out.println(formatter.format(ZonedDateTime.now()));
		
	}

}
