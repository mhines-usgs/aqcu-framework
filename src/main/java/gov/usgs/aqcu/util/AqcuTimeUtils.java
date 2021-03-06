package gov.usgs.aqcu.util;

import java.time.Instant;

import com.aquaticinformatics.aquarius.sdk.timeseries.serializers.InstantDeserializer;
import com.aquaticinformatics.aquarius.sdk.timeseries.servicemodels.Publish.PeriodOfApplicability;

public abstract class AqcuTimeUtils {
	public static final Instant OPEN_ENDED_START_THRESHOLD = InstantDeserializer.MinConcreteValue;
	public static final Instant OPEN_ENDED_END_THRESHOLD = InstantDeserializer.MaxConcreteValue;

	public static boolean doPeriodsOverlap(PeriodOfApplicability p1, PeriodOfApplicability p2) {
		return doesTimeRangeOverlap(p1.getStartTime(), p1.getEndTime(), p2.getStartTime(), p2.getEndTime());
	}

	//Note: Aquarius Time Ranges have INCLUSIVE Start Dates and EXCLUSIVE End Dates
	public static boolean doesTimeRangeOverlap(Instant start1, Instant end1, Instant start2, Instant end2) {
		return (start1.compareTo(end2) < 0 && end1.compareTo(start2) > 0);
	}

	public static boolean isOpenEndedTime(Instant time) {
		if(time.compareTo(OPEN_ENDED_START_THRESHOLD) <= 0 || time.compareTo(OPEN_ENDED_END_THRESHOLD) >= 0) {
			return true;
		}

		return false;
	}

	public static String toQueryDate(Instant time) {
		return time.toString().substring(0,10);
	}
}