//
//  AppDIContainer.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 11/19/23.
//

import Foundation

final class AppDIContainer {
    
    
    // MARK: - DIContainers of scenes
    func makeJourneySceneDIContainer() -> JourneySceneDIContainer {
        let dependencies = JourneySceneDIContainer.Dependencies()
        return JourneySceneDIContainer(dependencies: dependencies)
    }
}
