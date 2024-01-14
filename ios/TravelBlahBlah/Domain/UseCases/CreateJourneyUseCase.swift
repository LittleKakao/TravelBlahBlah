//
//  CreateJourneyUseCase.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 12/28/23.
//

import Foundation

protocol CreateJourneyUseCase {
    func execute(
        requestValue: CreateJourneyUseCaseRequestValue,
        completion: @escaping (Result<Void, Error>) -> Void
    ) -> Cancellable?
}

struct CreateJourneyUseCaseRequestValue {
    let query: JourneyQuery
    let journey: JourneyVO
}

final class DefaultCreateJourneyUseCase: CreateJourneyUseCase {
    
    private let journeyRepository: JourneyRepository
    
    init(
        journeyRepository: JourneyRepository
    ) {
        self.journeyRepository = journeyRepository
    }
    
    func execute(
        requestValue: CreateJourneyUseCaseRequestValue,
        completion: @escaping (Result<Void, Error>) -> Void
    ) -> Cancellable? {
        
        return
    }
}
