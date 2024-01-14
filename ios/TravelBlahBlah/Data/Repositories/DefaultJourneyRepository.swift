//
//  DefaultJourneyRepository.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 11/19/23.
//

import Foundation

//final class DefaultJourneyRepository: JourneyRepository {
//    
//    private let dataTransferService: DataTransferService
//    private let cache: JourneyResponseStorage
//    private let backgroundQueue: DataTransferDispatchQueue
//
//    init(
//        dataTransferService: DataTransferService,
//        cache: JourneyResponseStorage,
//        backgroundQueue: DataTransferDispatchQueue = DispatchQueue.global(qos: .userInitiated)
//    ) {
//        self.dataTransferService = dataTransferService
//        self.cache = cache
//        self.backgroundQueue = backgroundQueue
//    }
//}
//
//extension DefaultJourneyRepository {
//    func fetchJourneyList(query: JourneyQuery, cached: @escaping () -> Void, completion: @escaping (Result<Void, Error>) -> Void) -> Cancellable? {
//        <#code#>
//    }
//    
//}
