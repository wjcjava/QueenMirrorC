package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.timeutil;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by liuwan on 2016/9/28.
 */
public class CustomDatePicker {

    /**
     * 定义结果回调接口
     */
    public interface ResultHandler {
        void handle(String time);
    }

    public enum SCROLL_TYPE {

        MINUTE(2);

        SCROLL_TYPE(int value) {
            this.value = value;
        }

        public int value;
    }


    private ResultHandler handler;
    private Context context;
    private boolean canAccess = false;

    private Dialog datePickerDialog;
    private DatePickerView year_pv, month_pv, day_pv;

    private static final int MAX_MONTH = 12;

    private ArrayList<String> year, month, day;
    private int startYear, startMonth, startDay, endYear, endMonth, endDay;
    private int lastMonthDays; //上一个被选中的月份天数
    private String title;
    private String currentMon, currentDay; //当前选中的月、日、时、分
    private boolean spanYear, spanMon, spanDay;
    private Calendar selectedCalender, startCalendar, endCalendar;
    private TextView tv_title, tv_select,tv_cancle;


    public CustomDatePicker(Context context, String title, ResultHandler resultHandler, String startDate, String endDate) {
        if (isValidDate(startDate, "yyyy-MM-dd") && isValidDate(endDate, "yyyy-MM-dd")) {
            canAccess = true;
            this.context = context;
            this.handler = resultHandler;
            this.title = title;
            selectedCalender = Calendar.getInstance();
            startCalendar = Calendar.getInstance();
            endCalendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            try {
                startCalendar.setTime(sdf.parse(startDate));
                endCalendar.setTime(sdf.parse(endDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            initDialog();
            initView();
        }
    }

    private void initDialog() {
        if (datePickerDialog == null) {
            datePickerDialog = new Dialog(context, R.style.TimePickerDialog);
            datePickerDialog.setCancelable(true);
            datePickerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            datePickerDialog.setContentView(R.layout.custom_date_picker);
            Window window = datePickerDialog.getWindow();
            window.setGravity(Gravity.BOTTOM);
            WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(dm);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = dm.widthPixels;
            window.setAttributes(lp);
        }
    }

    private void initView() {
        year_pv = (DatePickerView) datePickerDialog.findViewById(R.id.year_pv);
        month_pv = (DatePickerView) datePickerDialog.findViewById(R.id.month_pv);
        day_pv = (DatePickerView) datePickerDialog.findViewById(R.id.day_pv);
        tv_title = (TextView) datePickerDialog.findViewById(R.id.tv_title);
        tv_cancle = datePickerDialog.findViewById(R.id.tv_cancle);
        tv_select = (TextView) datePickerDialog.findViewById(R.id.tv_select);


        tv_title.setText("在线预约");
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.dismiss();
            }
        });

        tv_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                handler.handle(sdf.format(selectedCalender.getTime()));
                datePickerDialog.dismiss();
            }
        });
    }

    private void initParameter() {
        startYear = startCalendar.get(Calendar.YEAR);
        startMonth = startCalendar.get(Calendar.MONTH) + 1;
        startDay = startCalendar.get(Calendar.DAY_OF_MONTH);

        endYear = endCalendar.get(Calendar.YEAR);
        endMonth = endCalendar.get(Calendar.MONTH) + 1;
        endDay = endCalendar.get(Calendar.DAY_OF_MONTH);

        spanYear = startYear != endYear;
        spanMon = (!spanYear) && (startMonth != endMonth);
        spanDay = (!spanMon) && (startDay != endDay);

        selectedCalender.setTime(startCalendar.getTime());
    }

    private void initTimer() {
        initArrayList();
        if (spanYear) {
            for (int i = startYear; i <= endYear; i++) {
                year.add(String.valueOf(i));
            }
            for (int i = startMonth; i <= MAX_MONTH; i++) {
                month.add(formatTimeUnit(i));
            }
            for (int i = startDay; i <= startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                day.add(formatTimeUnit(i));
            }
            if (spanMon) {
            year.add(String.valueOf(startYear));
            for (int i = startMonth; i <= endMonth; i++) {
                month.add(formatTimeUnit(i));
            }
            for (int i = startDay; i <= startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                day.add(formatTimeUnit(i));
            }


            }
        } else if (spanDay) {
            year.add(String.valueOf(startYear));
            month.add(formatTimeUnit(startMonth));
            for (int i = startDay; i <= endDay; i++) {
                day.add(formatTimeUnit(i));
            }

        }
        loadComponent();
    }

    /**
     * 将“0-9”转换为“00-09”
     */
    private String formatTimeUnit(int unit) {
        return unit < 10 ? "0" + String.valueOf(unit) : String.valueOf(unit);
    }

    private void initArrayList() {
        if (year == null) year = new ArrayList<>();
        if (month == null) month = new ArrayList<>();
        if (day == null) day = new ArrayList<>();
        year.clear();
        month.clear();
        day.clear();

    }

    private void loadComponent() {
        year_pv.setData(year);
        month_pv.setData(month);
        day_pv.setData(day);
        year_pv.setSelected(0);
        month_pv.setSelected(0);
        day_pv.setSelected(0);

        executeScroll();
    }

    private void addListener() {
        year_pv.setOnSelectListener(new DatePickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                selectedCalender.set(Calendar.YEAR, Integer.parseInt(text));
                monthChange();
            }
        });

        month_pv.setOnSelectListener(new DatePickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                selectedCalender.set(Calendar.DAY_OF_MONTH, 1);
                selectedCalender.set(Calendar.MONTH, Integer.parseInt(text) - 1);
                currentMon = text; //保存选择的月份
                dayChange();
            }
        });

        day_pv.setOnSelectListener(new DatePickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(text));
                currentDay = text;//保存选择的日期

            }
        });

    }

    private void monthChange() {
        month.clear();
        int selectedYear = selectedCalender.get(Calendar.YEAR);
        if (selectedYear == startYear) {
            for (int i = startMonth; i <= MAX_MONTH; i++) {
                month.add(formatTimeUnit(i));
            }
        } else if (selectedYear == endYear) {
            for (int i = 1; i <= endMonth; i++) {
                month.add(formatTimeUnit(i));
            }
        } else {
            for (int i = 1; i <= MAX_MONTH; i++) {
                month.add(formatTimeUnit(i));
            }
        }
//        selectedCalender.set(Calendar.MONTH, Integer.parseInt(month.get(0)) - 1);
        month_pv.setData(month);
        if (month.size() < MAX_MONTH && Integer.valueOf(currentMon) > month.size()) {
            month_pv.setSelected(month.size() - 1);
            selectedCalender.set(Calendar.DAY_OF_MONTH, 1);
            selectedCalender.set(Calendar.MONTH, month.size() - 1);
        } else {
            month_pv.setSelected(currentMon);
            selectedCalender.set(Calendar.DAY_OF_MONTH, 1);
            selectedCalender.set(Calendar.MONTH, Integer.valueOf(currentMon) - 1);
        }


        month_pv.postDelayed(new Runnable() {
            @Override
            public void run() {
                dayChange();
            }
        }, 100);
    }

    private void dayChange() {
        day.clear();
        int selectedYear = selectedCalender.get(Calendar.YEAR);
        int selectedMonth = selectedCalender.get(Calendar.MONTH) + 1;
        if (selectedYear == startYear && selectedMonth == startMonth) {
            for (int i = startDay; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                day.add(formatTimeUnit(i));
            }
        } else if (selectedYear == endYear && selectedMonth == endMonth) {
            for (int i = 1; i <= endDay; i++) {
                day.add(formatTimeUnit(i));
            }
        } else {
            for (int i = 1; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                day.add(formatTimeUnit(i));
            }
        }
        day_pv.setData(day);
//        selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day.get(0)));
//        day_pv.setSelected(0);
        if (day.size() < lastMonthDays && Integer.valueOf(currentDay) > day.size()) {
            day_pv.setSelected(day.size() - 1);
            currentDay = formatTimeUnit(day.size());
        } else {
            day_pv.setSelected(currentDay);
        }
        selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(currentDay));
        //重新赋值
        lastMonthDays = day.size();



    }



    private void executeScroll() {
        year_pv.setCanScroll(year.size() > 1);
        month_pv.setCanScroll(month.size() > 1);
        day_pv.setCanScroll(day.size() > 1);

    }


    public void show(String time) {
        if (canAccess) {
            if (isValidDate(time, "yyyy-MM-dd")) {
                if (startCalendar.getTime().getTime() < endCalendar.getTime().getTime()) {
                    canAccess = true;
                    initParameter();
                    initTimer();
                    addListener();
                    setSelectedTime(time);
                    datePickerDialog.show();
                }
            } else {
                canAccess = false;
            }
        }
    }

    /**
     * 设置日期控件是否可以循环滚动
     */
    public void setIsLoop(boolean isLoop) {
        if (canAccess) {
            this.year_pv.setIsLoop(isLoop);
            this.month_pv.setIsLoop(isLoop);
            this.day_pv.setIsLoop(isLoop);

        }
    }

    public void setYearIsLoop(boolean isLoop) {
        if (canAccess) {
            this.year_pv.setIsLoop(isLoop);
        }
    }

    public void setMonIsLoop(boolean isLoop) {
        if (canAccess) {
            this.month_pv.setIsLoop(isLoop);
        }
    }

    public void setDayIsLoop(boolean isLoop) {
        if (canAccess) {
            this.day_pv.setIsLoop(isLoop);
        }
    }



    /**
     * 设置日期控件默认选中的时间
     */
    public void setSelectedTime(String time) {
        if (canAccess) {
            String[] str = time.split(" ");
            String[] dateStr = str[0].split("-");

            year_pv.setSelected(dateStr[0]);
            selectedCalender.set(Calendar.YEAR, Integer.parseInt(dateStr[0]));

            month.clear();
            int selectedYear = selectedCalender.get(Calendar.YEAR);
            if (selectedYear == startYear) {
                for (int i = startMonth; i <= MAX_MONTH; i++) {
                    month.add(formatTimeUnit(i));
                }
            } else if (selectedYear == endYear) {
                for (int i = 1; i <= endMonth; i++) {
                    month.add(formatTimeUnit(i));
                }
            } else {
                for (int i = 1; i <= MAX_MONTH; i++) {
                    month.add(formatTimeUnit(i));
                }
            }
            month_pv.setData(month);
            month_pv.setSelected(dateStr[1]);
            currentMon = dateStr[1]; //保存选择的月份
            selectedCalender.set(Calendar.MONTH, Integer.parseInt(dateStr[1]) - 1);


            day.clear();
            int selectedMonth = selectedCalender.get(Calendar.MONTH) + 1;
            if (selectedYear == startYear && selectedMonth == startMonth) {
                for (int i = startDay; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                    day.add(formatTimeUnit(i));
                }
            } else if (selectedYear == endYear && selectedMonth == endMonth) {
                for (int i = 1; i <= endDay; i++) {
                    day.add(formatTimeUnit(i));
                }
            } else {
                for (int i = 1; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                    day.add(formatTimeUnit(i));
                }
            }
            lastMonthDays = day.size();
            day_pv.setData(day);
            day_pv.setSelected(dateStr[2]);
            currentDay = dateStr[2]; //保存选择的日
            selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateStr[2]));


            if (str.length == 2)
            executeScroll();
        }
    }

    /**
     * 验证字符串是否是一个合法的日期格式
     */
    private boolean isValidDate(String date, String template) {
        boolean convertSuccess = true;
        // 指定日期格式
        SimpleDateFormat format = new SimpleDateFormat(template, Locale.CHINA);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2015/02/29会被接受，并转换成2015/03/01
            format.setLenient(false);
            format.parse(date);
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }
}
