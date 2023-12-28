//
//  JourneySceneDIContainer.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 11/28/23.
//

import UIKit

final class JourneySceneDIContainer: JourneySceneFlowCoordinatorDependencies {
    
    struct Dependencies {
        
    }
    private let dependencies: Dependencies
    
    init(dependencies: Dependencies) {
        self.dependencies = dependencies
    }
    
    // MARK: - Main Scene
    func makeMainViewController(actions: MainViewModelActions) -> MainViewController {
        MainViewController.create(
            with: makeMainViewModel(actions: actions)
        )
    }
    
    func makeMainViewModel(actions: MainViewModelActions) -> MainViewModel {
        MainViewModel(actions: actions)
    }
    
    // MARK: - Create Journey
    func makeCreateJourneyViewController() -> CreateJourneyViewController {
        CreateJourneyViewController.create(
            with: makeCreateJourneyViewModel()
        )
    }
    
    func makeCreateJourneyViewModel() -> CreateJourneyViewModel {
        DefaultCreateJourneyViewModel()
    }
    
    // MARK: - Flow Coordinators
    func makeJourneySceneFlowCoordinator(navigationController: UINavigationController) -> JourneySceneFlowCoordinator {
        
        JourneySceneFlowCoordinator(navigationController: navigationController, dependencies: self)
        
    }
}
