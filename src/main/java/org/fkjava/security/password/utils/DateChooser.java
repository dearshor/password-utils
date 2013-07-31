package org.fkjava.security.password.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author lwq
 */
public class DateChooser extends JPanel implements ActionListener,
        ChangeListener {

    private int startYear = 1900;
    private int lastYear = 2050;
    private int width = 200;
    private int height = 200;
    private Color backGroundColor = Color.gray;
    private Color palletTableColor = Color.lightGray;
    private Color todayBackColor = Color.GREEN;
    private Color weekFontColor = Color.blue;
    private Color dateFontColor = Color.black;
    private Color weekendFontColor = Color.red;
    private Color controlLineColor = Color.BLUE;
    private Color controlTextColor = Color.white;
    private JDialog dialog;
    private JSpinner yearSpin;
    private JSpinner monthSpin;
    private JSpinner hourSpin;
    private JButton[][] daysButton = new JButton[6][7];
    private JTextField jTextField1;
    
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public DateChooser(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
        setLayout(new BorderLayout());
        setBorder(new LineBorder(backGroundColor, 2));
        setBackground(backGroundColor);
        JPanel topYearAndMonth = createYearAndMonthPanal();
        add(topYearAndMonth, BorderLayout.NORTH);
        JPanel centerWeekAndDay = createWeekAndDayPanal();
        add(centerWeekAndDay, BorderLayout.CENTER);
        showDateChooser();
    }

    private void setDate(Calendar date) {
        jTextField1.setText(dateFormat.format(date.getTime()));
    }

    private JPanel createYearAndMonthPanal() {
        Calendar c = getCalendar();
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        int currentHour = c.get(Calendar.HOUR_OF_DAY);
        JPanel result = new JPanel();
        result.setBackground(controlLineColor);
        yearSpin = new JSpinner(new SpinnerNumberModel(currentYear,
                startYear, lastYear, 1));
        yearSpin.setPreferredSize(new Dimension(48, 20));
        yearSpin.setName("Year");
        yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
        yearSpin.addChangeListener(this);
        result.add(yearSpin);
        JLabel yearLabel = new JLabel("年");
        yearLabel.setForeground(controlTextColor);
        result.add(yearLabel);
        monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth, 1, 12, 1));
        monthSpin.setPreferredSize(new Dimension(35, 20));
        monthSpin.setName("Month");
        monthSpin.addChangeListener(this);
        result.add(monthSpin);
        JLabel monthLabel = new JLabel("月");
        monthLabel.setForeground(controlTextColor);
        result.add(monthLabel);
        return result;
    }

    private JPanel createWeekAndDayPanal() {
        String colname[] = {"日", "一", "二", "三", "四", "五", "六"};
        JPanel result = new JPanel();
        result.setFont(new Font("宋体", Font.PLAIN, 12));
        result.setLayout(new GridLayout(7, 7));
        result.setBackground(Color.white);
        JLabel cell;
        for (int i = 0; i < 7; i++) {
            cell = new JLabel(colname[i]);
            cell.setHorizontalAlignment(JLabel.RIGHT);
            if (i == 0 || i == 6) {
                cell.setForeground(weekendFontColor);
            } else {
                cell.setForeground(weekFontColor);
            }
            result.add(cell);
        }

        int actionCommandId = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                JButton numberButton = new JButton();
                numberButton.setBorder(null);
                numberButton.setHorizontalAlignment(SwingConstants.RIGHT);
                numberButton.setActionCommand(String.valueOf(actionCommandId));
                numberButton.addActionListener(this);
                numberButton.setBackground(palletTableColor);
                numberButton.setForeground(dateFontColor);
                if (j == 0 || j == 6) {
                    numberButton.setForeground(weekendFontColor);
                } else {
                    numberButton.setForeground(dateFontColor);
                }
                daysButton[i][j] = numberButton;
                result.add(numberButton);
                actionCommandId++;
            }
        }
        return result;
    }

    private JDialog createDialog(Frame owner) {
        JDialog result = new JDialog(owner, "日期时间选择", true);
        result.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        result.getContentPane().add(this, BorderLayout.CENTER);
        result.pack();
        result.setSize(width, height);
        return result;
    }

    private void showDateChooser() {
        Point p = jTextField1.getLocationOnScreen();
        p.y = p.y + (int) jTextField1.getSize().getHeight();
        Point position = p;
        Frame owner = (Frame) SwingUtilities.getWindowAncestor(jTextField1.
                getParent().getParent());
        //DateChooserJbutton.this);
        if (dialog == null || dialog.getOwner() != owner) {
            dialog = createDialog(owner);
        }
        //dialog.setLocation(getAppropiateLocation(owner.position));
        dialog.setLocation(position);
        flushWeekAndDay();
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    private Date getDate() {
        Date date1;
        String dateString = jTextField1.getText();
        try {
            date1 = dateFormat.parse(dateString);
        } catch (Exception e) {
            date1 = Calendar.getInstance().getTime();
        }
        return date1;
    }

    private Calendar getCalendar() {
        Calendar result = Calendar.getInstance();
        result.setTime(getDate());
        //System.out.println(bartDateFormat.format(result.getTime()));
        return result;
    }

    private int getSelectedYear() {
        return ((Integer) yearSpin.getValue()).intValue();
    }

    private int getSelectedMonth() {
        return ((Integer) monthSpin.getValue()).intValue();
    }

    private int getSelectedHour() {
        return ((Integer) hourSpin.getValue()).intValue();
    }

    private void dayColorUpdate(boolean isOldDay) {
        Calendar c = getCalendar();
        int day = c.get(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, 1);
        int actionCommandId = day - 2 + c.get(Calendar.DAY_OF_WEEK);
        int i = actionCommandId / 7;
        int j = actionCommandId % 7;
        if (isOldDay) {
            daysButton[i][j].setForeground(dateFontColor);
        } else {
            daysButton[i][j].setForeground(todayBackColor);
        }
    }

    private void flushWeekAndDay() {
        Calendar c = getCalendar();
        c.set(Calendar.DAY_OF_MONTH, 1);
        int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayNo = c.get(Calendar.DAY_OF_WEEK);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String s = "";
                if (dayNo >= 1 && dayNo <= maxDayNo) {
                    s = String.valueOf(dayNo);
                }
                daysButton[i][j].setText(s);
                dayNo++;
            }
        }
        dayColorUpdate(false);
    }

    public void stateChanged(ChangeEvent e) {
        JSpinner source = (JSpinner) e.getSource();
        Calendar c = getCalendar();
        dayColorUpdate(true);
        if (source.getName().equals("Year")) {
            c.set(Calendar.YEAR, getSelectedYear());
        } else {
            c.set(Calendar.MONTH, getSelectedMonth() - 1);
        }
        setDate(c);
        flushWeekAndDay();
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source.getText().length() == 0) {
            return;
        }
        dayColorUpdate(true);
        source.setForeground(todayBackColor);
        int newDay = Integer.parseInt(source.getText());
        Calendar c = getCalendar();
        c.set(Calendar.DAY_OF_MONTH, newDay);
        setDate(c);
        dialog.setVisible(false);
    }
}
