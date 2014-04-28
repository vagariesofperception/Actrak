package fun.app.actrak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;
import android.widget.CalendarView.OnDateChangeListener;

public class ActrakMainActivity extends FragmentActivity {
	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actrak_main);

		// Create the adapter that will return a fragment for each of the two
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		mViewPager.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
			}
		});

	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter  {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0: return getString(R.string.title_section1).toUpperCase();
			case 1: return getString(R.string.title_section2).toUpperCase();
			}
			return null;
		}

	}

	public static class DummySectionFragment extends Fragment  {
		public DummySectionFragment() {
		}

		public static final String ARG_SECTION_NUMBER = "section_number";


		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			// Get section number
			Bundle args = getArguments();
			int sectionNum = args.getInt(ARG_SECTION_NUMBER);

			// Section 1: Graph
			if (sectionNum == 1) {
				View v = inflater.inflate(R.layout.actrak_graph, container, false);
				v.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO(pprabhu)
					}
				});
				return v;
			} else {
				// Section 2: Activity Data

				// Create calendar view, can click on it, and it listens to date change
				CalendarView calView = new CalendarView(getActivity());
				calView.setClickable(true);

				calView.setOnDateChangeListener(new OnDateChangeListener() {

					@Override
					public void onSelectedDayChange(CalendarView view, int year, int month,
							int dayOfMonth) {
						// TODO(pprabhu)

					}
				});
				return calView;
			}

		}
	}

}
