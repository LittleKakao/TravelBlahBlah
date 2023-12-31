//
//  AppConfigurations.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 12/31/23.
//

import Foundation

final class AppConfiguration {
    
    lazy var apiBaseURL: String = {
        guard let apiBaseURL = Bundle.main.object(forInfoDictionaryKey: "API_BASE_URL") as? String else {
            fatalError("API_BASE_URL must not be empty in plist")
        }
        return apiBaseURL
    }()
}
