//
//  JourneySceneFlowCoordinator.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 12/16/23.
//

import UIKit

protocol JourneySceneFlowCoordinatorDependencies {
    func makeMainViewController(actions: MainViewModelActions) -> MainViewController
    func makeCreateJourneyViewController() -> CreateJourneyViewController
}

final class JourneySceneFlowCoordinator {
    
    private weak var navigationController: UINavigationController?
    private let dependencies: JourneySceneFlowCoordinatorDependencies
    
    init(navigationController: UINavigationController, dependencies: JourneySceneFlowCoordinatorDependencies) {
        self.navigationController = navigationController
        self.dependencies = dependencies
    }
    
    func start() {
        
        let actions = MainViewModelActions(showCreateJourneyView: showCreateJourneyView)
        
        let vc = dependencies.makeMainViewController(actions: actions)
        navigationController?.pushViewController(vc, animated: false)
    }
    
    private func showCreateJourneyView() {
        let vc = dependencies.makeCreateJourneyViewController()
        navigationController?.pushViewController(vc, animated: true)
    }
}
