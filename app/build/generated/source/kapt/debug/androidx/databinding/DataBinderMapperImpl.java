package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new ru.nsu.hackatonapp.DataBinderMapperImpl());
  }
}
