import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class NopModel implements ModelInterface {

	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		return null;
	}

	@Override
	public int insert(String fieldNames, List<Object> rows) throws Exception {
		return 0;
	}

	@Override
	public int insert2(String fieldNames, List<Object> rows) throws Exception {
		return 0;
	}

	@Override
	public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
		return 0;
	}

	@Override
	public int update2(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
		return 0;
	}

	@Override
	public int delete(Map<String, Object> whereParameters) throws Exception {
		return 0;
	}

	@Override
	public ResultSet select2(Map<String, Object> whereParameters) throws Exception {
		return null;
	}

	@Override
	public ResultSet select1(Map<String, Object> whereParameters) throws Exception {
		return null;
	}

	@Override
	public ResultSet select4(Map<String, Object> whereParameters) throws Exception {
		return null;
	}


	@Override
	public String toString() {
		return "No Operation Model";
	}
}
