//
//  DataTransferService.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 12/31/23.
//

import Foundation

protocol DataTransferService {
}

final class DefaultDataTransferService {
    
    private let networkService: NetworkService
    
    init(
        with networkService: NetworkService
    ) {
        self.networkService = networkService
    }
}

extension DefaultDataTransferService: DataTransferService {
    
}
