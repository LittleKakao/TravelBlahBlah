//
//  MainViewModel.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 11/19/23.
//

import UIKit

struct MainViewModelActions {
    let showCreateJourneyView: () -> Void
}

class MainViewModel {
        
    private let actions: MainViewModelActions?
    
    // MARK: - Init
    
    init(
        actions: MainViewModelActions? = nil
    ) {
        self.actions = actions
    }
    
}

// MARK: - INPUT. View event methods
extension MainViewModel {
    
    func viewDidLoad() { }
    
    func didTappedButton() {
        actions?.showCreateJourneyView()
    }
}
