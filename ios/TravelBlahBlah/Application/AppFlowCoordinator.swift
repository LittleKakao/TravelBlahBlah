//
//  AppFlowCoordinator.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 11/28/23.
//

import UIKit

final class AppFlowCoordinator {
    
    var navigationController: UINavigationController
    private let appDIContainer: AppDIContainer
    
    init(
        navigationController: UINavigationController,
        appDIContainer: AppDIContainer
    ) {
        self.navigationController = navigationController
        self.appDIContainer = appDIContainer
    }
    
    func start() {
        // In App Flow we can check if user needs to login, if yes we would run login flow
        let journeySceneDIContainer = appDIContainer.makeJourneySceneDIContainer()
        let flow = journeySceneDIContainer.makeJourneySceneFlowCoordinator(navigationController: navigationController)
        flow.start()
    }
}
