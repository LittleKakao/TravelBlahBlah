package com.littlekakao.travelblahblah.ui.journey

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.littlekakao.travelblahblah.ui.base.BottomNavigation
import kotlinx.coroutines.launch


class JourneyViewModel : ViewModel() {
//    // 현재 선택된 탭을 추적하는 상태
//    private val selectedTabPrivate = MutableLiveData<BottomNavigation>()
//    val selectedTab: LiveData<BottomNavigation> get() = selectedTabPrivate
//
//    init {
//        // 초기 탭 설정
//        selectedTabPrivate.value = ListMenu
//    }
//
//    // 네비게이션 탭 변경
//    fun onTabSelected(tab: BottomNavigation) {
//        selectedTabPrivate.value = tab
//    }
//
//    // 여행 목록 로드
//    fun loadJourneyList() {
//        viewModelScope.launch {
//            // TODO: 여행 목록 데이터 로드 로직
//        }
//    }
//
//    // 캘린더 데이터 로드
//    fun loadJourneyCalendar() {
//        viewModelScope.launch {
//            // TODO: 캘린더 데이터 로드 로직
//        }
//    }
}